package calendar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Lists;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.Calendar.Calendars.Get;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import com.google.gdata.client.calendar.CalendarQuery;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.calendar.WebContent;
import com.google.gdata.data.extensions.Recurrence;
import com.google.gdata.data.extensions.When;
import com.google.gdata.data.extensions.Where;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class CalendarUtils {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
	/**
	 * Be sure to specify the name of your application. If the application name
	 * is {@code null} or blank, the application will log a warning. Suggested
	 * format is "MyCompany-ProductName/1.0".
	 */
	private static final String APPLICATION_NAME = "";

	/** Directory to store user credentials. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".store/calendar_sample");

	/**
	 * Global instance of the {@link DataStoreFactory}. The best practice is to
	 * make it a single globally shared instance across your application.
	 */
	private static FileDataStoreFactory dataStoreFactory;

	/** Global instance of the HTTP transport. */
	private static HttpTransport httpTransport;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	private static com.google.api.services.calendar.Calendar client;

	private static com.google.api.services.calendar.model.Calendar calendar;

	static final java.util.List<Calendar> addedCalendarsUsingBatch = Lists.newArrayList();

	// Calendrier du championnat
	private static String CALENDAR = "7m7f052020pvc2ef8pfg2dsia0@group.calendar.google.com";

	/** Authorizes the installed application to access user's protected data. */
	private static Credential authorize() throws Exception {

		InputStream is = new FileInputStream("client_secrets.json");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		// load client secrets
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, br);
		if (clientSecrets.getDetails().getClientId().startsWith("Enter") || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
			System.out.println("Enter Client ID and Secret from https://code.google.com/apis/console/?api=calendar "
					+ "into calendar-cmdline-sample/src/main/resources/client_secrets.json");
			System.exit(1);
		}
		// set up authorization code flow
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
				Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(dataStoreFactory).build();
		// authorize
		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}

	public static void initCalendarUtils() {
		try {
			// initialize the transport
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();

			// initialize the data store factory
			dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);

			// authorization
			Credential credential = authorize();

			// set up global Calendar instance
			client = new com.google.api.services.calendar.Calendar.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(
					APPLICATION_NAME).build();

			calendar = client.calendars().get(CALENDAR).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EventDayKB dateRangeQuery(long startTime, long endTime) throws ServiceException, IOException, ParseException {

		EventDayKB eventDayKB = new EventDayKB();
		List<EventKB> events = new ArrayList<EventKB>();
		eventDayKB.setEvents(events);

		com.google.api.services.calendar.Calendar.Events.List list = client.events().list(calendar.getId());

		list.setTimeMax(new com.google.api.client.util.DateTime(endTime));
		list.setTimeMin(new com.google.api.client.util.DateTime(startTime));

		Events resultFeed = list.execute();
		System.out.println("Events from " + new Date(startTime).toString() + " to " + new Date(endTime).toString() + ":");

		if (resultFeed.getItems().isEmpty()) {
			System.out.println("Il n'y a pas d'évènement pour cette journée");
		} else {
			System.out.println("Il y a " + (resultFeed.getItems().size() - 1) + " match pour cette journée");
			for (int i = resultFeed.getItems().size() - 1; i != -1; i--) {

				EventKB event = new EventKB();

				Event entry = resultFeed.getItems().get(i);
				event.setCalendarEventEntry(entry);

				String commentaire = entry.getDescription();
				String[] values = commentaire.split("\\|\\|");

				// MATCH
				if ("M".equals(values[0])) {
					
					event.setDebut(TIME_FORMAT.parse(TIME_FORMAT.format(new Date(entry.getStart().getDateTime().getValue()))).getTime());
					event.setFin(TIME_FORMAT.parse(TIME_FORMAT.format(new Date(entry.getEnd().getDateTime().getValue()))).getTime());

					event.setHomme("M".equals(values[1]) ? true : false);
					event.setIdMatch(values[2]);
					event.setEquipeBleu(values[3]);
					event.setEquipeGris(values[4]);
					event.setEquipeNoir(values[5]);

					events.add(event);
					System.out.println(event.toString());

					// JOURNEE
				} else if ("J".equals(values[0])) {
					eventDayKB.setDate(entry.getStart().getDate().getValue());

					eventDayKB.setVille(entry.getLocation());
					eventDayKB.setTitre(entry.getSummary());
					eventDayKB.setCalendarEventEntry(entry);

				} else {
					System.out.println("ERROR FORMATING");
				}
			}
			System.out.println(eventDayKB.toString());
		}
		
		// order by date de début
		Collections.sort(eventDayKB.getEvents(), new Comparator<EventKB>() {
			  public int compare(EventKB o1, EventKB o2) {
			      return new Date(o1.getDebut()).compareTo(new Date(o2.getDebut()));
			  }
			});
		
		return eventDayKB;
	}

	/**
	 * Helper method to create either single-instance or recurring events. For
	 * simplicity, some values that might normally be passed as parameters (such
	 * as author name, email, etc.) are hard-coded.
	 * 
	 * @param service
	 *            An authenticated CalendarService object.
	 * @param eventTitle
	 *            Title of the event to create.
	 * @param eventContent
	 *            Text content of the event to create.
	 * @param recurData
	 *            Recurrence value for the event, or null for single-instance
	 *            events.
	 * @param isQuickAdd
	 *            True if eventContent should be interpreted as the text of a
	 *            quick add event.
	 * @param wc
	 *            A WebContent object, or null if this is not a web content
	 *            event.
	 * @return The newly-created CalendarEventEntry.
	 * @throws ServiceException
	 *             If the service is unable to handle the request.
	 * @throws IOException
	 *             Error communicating with the server.
	 */
	// public static CalendarEventEntry createEvent(CalendarService service,
	// String eventTitle, String eventContent, String recurData,
	// boolean isQuickAdd, WebContent wc) throws ServiceException, IOException {
	//
	//
	//
	// CalendarEventEntry myEntry = new CalendarEventEntry();
	//
	// myEntry.setTitle(new PlainTextConstruct(eventTitle));
	// myEntry.setContent(new PlainTextConstruct(eventContent));
	// myEntry.setQuickAdd(isQuickAdd);
	// myEntry.setWebContent(wc);
	//
	// // If a recurrence was requested, add it. Otherwise, set the
	// // time (the current date and time) and duration (30 minutes)
	// // of the event.
	// if (recurData == null) {
	// Calendar calendar = new GregorianCalendar();
	// DateTime startTime = new DateTime(calendar.getTime(),
	// TimeZone.getDefault());
	//
	// calendar.add(Calendar.MINUTE, 30);
	// DateTime endTime = new DateTime(calendar.getTime(),
	// TimeZone.getDefault());
	//
	// When eventTimes = new When();
	// eventTimes.setStartTime(startTime);
	// eventTimes.setEndTime(endTime);
	// myEntry.addTime(eventTimes);
	// } else {
	// Recurrence recur = new Recurrence();
	// recur.setValue(recurData);
	// myEntry.setRecurrence(recur);
	// }
	//
	// // Send the request and receive the response:
	// return service.insert(eventFeedUrl, myEntry);
	// }

	public static Event createDayEvent(String titre, String description, long date, String ville) throws ServiceException, IOException {
		Event event = new Event();
		event.setSummary(titre);

		setEventDates(date, event);

		event.setDescription(description);
		event.setLocation(ville);

		// Send the request and receive the response:
		return client.events().insert(calendar.getId(), event).execute();
	}

	private static void setEventDates(long date, Event event) {
		Date startDate = new Date(date);
		// An all-day event is 1 day (or 86400000 ms) long
		Date endDate = new Date(startDate.getTime() + 86400000);

		String startDateStr = DATE_FORMAT.format(startDate);
		String endDateStr = DATE_FORMAT.format(endDate);

		// Out of the 6 methods for creating a DateTime object with no time
		// element, only the String version works
		com.google.api.client.util.DateTime startDateTime = new com.google.api.client.util.DateTime(startDateStr);
		com.google.api.client.util.DateTime endDateTime = new com.google.api.client.util.DateTime(endDateStr);

		// Must use the setDate() method for an all-day event (setDateDate() is
		// used for timed events)
		EventDateTime startEventDateTime = new EventDateTime().setDate(startDateTime);
		EventDateTime endEventDateTime = new EventDateTime().setDate(endDateTime);

		event.setStart(startEventDateTime);
		event.setEnd(endEventDateTime);
	}

	private static void setEventBothDates(EventKB eventKB, Event event, long date) {

		com.google.api.client.util.DateTime startDateTime = new com.google.api.client.util.DateTime(eventKB.getDebut() + date + (60 * 60 * 1000));
		com.google.api.client.util.DateTime endDateTime = new com.google.api.client.util.DateTime(eventKB.getFin() + date + (60 * 60 * 1000));

		// Must use the setDate() method for an all-day event (setDateDate() is
		// used for timed events)
		EventDateTime startEventDateTime = new EventDateTime().setDateTime(startDateTime);
		EventDateTime endEventDateTime = new EventDateTime().setDateTime(endDateTime);

		event.setStart(startEventDateTime);
		event.setEnd(endEventDateTime);
	}

	public static Event updateDayEvent(Event event, String titre, String description, long date, String ville) throws IOException, ServiceException {
		event.setSummary(titre);
		setEventDates(date, event);
		event.setDescription(description);
		event.setLocation(ville);

		return client.events().update(calendar.getId(), event.getId(), event).execute();
	}

	private static String getTitreFromEvent(EventKB eventKB) {
		StringBuilder sbTitre = new StringBuilder();
		sbTitre.append("#");
		sbTitre.append(eventKB.getIdMatch());
		sbTitre.append(" ");
		sbTitre.append(eventKB.getEquipeBleu());
		sbTitre.append(" - ");
		sbTitre.append(eventKB.getEquipeGris());
		sbTitre.append(" - ");
		sbTitre.append(eventKB.getEquipeNoir());

		return sbTitre.toString();
	}

	private static String getCommentaireFromEvent(EventKB eventKB) {
		StringBuilder sbCommentaire = new StringBuilder();
		sbCommentaire.append("M");
		sbCommentaire.append("||");
		sbCommentaire.append((eventKB.isHomme() ? "M" : "F"));
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getIdMatch());
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getEquipeBleu());
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getEquipeGris());
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getEquipeNoir());
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getDebut());
		sbCommentaire.append("||");
		sbCommentaire.append(eventKB.getFin());
		return sbCommentaire.toString();
	}

	// private static When getPeriodeFromEvent(EventKB eventKB) {
	// DateTime startTime = new DateTime(new Date(eventKB.getDebut()),
	// TimeZone.getDefault());
	// DateTime endTime = new DateTime(new Date(eventKB.getFin()),
	// TimeZone.getDefault());
	//
	// When eventTimes = new When();
	// eventTimes.setStartTime(startTime);
	// eventTimes.setEndTime(endTime);
	//
	// return eventTimes;
	// }

	public static Event createEvent(EventKB eventKB, String ville, long date) throws IOException, ServiceException {
		Event event = new Event();
		event.setSummary(getTitreFromEvent(eventKB));
		event.setDescription(getCommentaireFromEvent(eventKB));
		event.setLocation(ville);
		setEventBothDates(eventKB, event, date);

		// Send the request and receive the response:
		return client.events().insert(calendar.getId(), event).execute();
	}

	public static Event updateEvent(EventKB eventKB, String ville, long date) throws IOException, ServiceException {

		eventKB.getCalendarEventEntry().setSummary(getTitreFromEvent(eventKB));
		eventKB.getCalendarEventEntry().setDescription(getCommentaireFromEvent(eventKB));
		eventKB.getCalendarEventEntry().setLocation(ville);
		setEventBothDates(eventKB, eventKB.getCalendarEventEntry(), date);

		return client.events().update(calendar.getId(), eventKB.getCalendarEventEntry().getId(), eventKB.getCalendarEventEntry()).execute();
	}

}
