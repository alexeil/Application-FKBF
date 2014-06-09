package calendar;

//
//import java.io.IOException;
//import java.io.ObjectInputStream.GetField;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.TimeZone;
// 
//import com.google.gdata.client.calendar.CalendarQuery;
//import com.google.gdata.client.calendar.CalendarService;
//import com.google.gdata.data.DateTime;
//import com.google.gdata.data.PlainTextConstruct;
//import com.google.gdata.data.calendar.CalendarEventEntry;
//import com.google.gdata.data.calendar.CalendarEventFeed;
//import com.google.gdata.data.calendar.WebContent;
//import com.google.gdata.data.extensions.Recurrence;
//import com.google.gdata.data.extensions.When;
//import com.google.gdata.data.extensions.Where;
//import com.google.gdata.util.AuthenticationException;
//import com.google.gdata.util.ServiceException;
//
public class CopyOfCalendarUtils
{
    //
    // SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    // SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    //
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //
    // // The base URL for a user's calendar metafeed (needs a username
    // appended).
    // private static final String METAFEED_URL_BASE =
    // "https://www.google.com/calendar/feeds/";
    //
    // // The string to add to the user's metafeedUrl to access the event feed
    // for
    // // their primary calendar.
    // private static final String EVENT_FEED_URL_SUFFIX = "/private/full";
    //
    // // The URL for the metafeed of the specified user.
    // // (e.g. http://www.google.com/feeds/calendar/jdoe@gmail.com)
    // private static URL metafeedUrl = null;
    //
    // // The URL for the event feed of the specified user's primary calendar.
    // // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
    // private static URL eventFeedUrl = null;
    //
    // private static CalendarService myService;
    //
    // public static void initCalendarUtils() {
    //
    // // Calendrier du championnat
    // String calendar = "7m7f052020pvc2ef8pfg2dsia0@group.calendar.google.com";
    // myService = new CalendarService(calendar);
    //
    // String userName = "fkbf@kin-ball.fr";
    // String userPassword = "22kin35ball49";
    // // Create the necessary URL objects.
    // try {
    // metafeedUrl = new URL(METAFEED_URL_BASE + userName);
    // eventFeedUrl = new URL(METAFEED_URL_BASE + calendar +
    // EVENT_FEED_URL_SUFFIX);
    // } catch (MalformedURLException e) {
    // // Bad URL
    // System.err.println("Uh oh - you've got an invalid URL.");
    // e.printStackTrace();
    // return;
    // }
    // try {
    // myService.setUserCredentials(userName, userPassword);
    // } catch (AuthenticationException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // public static EventDayKB dateRangeQuery(DateTime startTime, DateTime
    // endTime) throws ServiceException, IOException, ParseException {
    //
    // EventDayKB eventDayKB = new EventDayKB();
    //
    // List<EventKB> events = new ArrayList<EventKB>();
    // eventDayKB.setEvents(events);
    //
    // CalendarQuery myQuery = new CalendarQuery(eventFeedUrl);
    // myQuery.setMinimumStartTime(startTime);
    // myQuery.setMaximumStartTime(endTime);
    //
    // // Send the request and receive the response:
    // CalendarEventFeed resultFeed = myService.query(myQuery,
    // CalendarEventFeed.class);
    //
    // System.out.println("Events from " + startTime.toString() + " to " +
    // endTime.toString() + ":");
    //
    // if (resultFeed.getEntries().isEmpty()) {
    // System.out.println("Il n'y a pas d'évènement pour cette journée");
    // } else {
    // for (int i = resultFeed.getEntries().size() - 1; i != 0; i--) {
    // System.out.println("Il y a " + resultFeed.getEntries().size() +
    // " évènements pour cette journée");
    // EventKB event = new EventKB();
    //
    // CalendarEventEntry entry = resultFeed.getEntries().get(i);
    // event.setCalendarEventEntry(entry);
    //
    // List<com.google.gdata.data.extensions.When> whens = entry.getTimes();
    // event.setDebut(whens.get(0).getStartTime().getValue());
    // event.setFin(whens.get(0).getEndTime().getValue());
    //
    // String commentaire = entry.getPlainTextContent();
    // String[] values = commentaire.split("\\|\\|");
    //
    // // MATCH
    // if ("M".equals(values[0])) {
    // event.setHomme("M".equals(values[1]) ? true : false);
    // event.setIdMatch(values[2]);
    // event.setEquipeBleu(values[3]);
    // event.setEquipeGris(values[4]);
    // event.setEquipeNoir(values[5]);
    //
    // events.add(event);
    // System.out.println(event.toString());
    //
    // // JOURNEE
    // } else if (null == commentaire || "".equals(commentaire)) {
    // eventDayKB.setDate(whens.get(0).getStartTime().getValue());
    // eventDayKB.setVille(entry.getLocations().get(0).getValueString());
    // eventDayKB.setTitre(entry.getTitle().getPlainText());
    // eventDayKB.setCalendarEventEntry(entry);
    //
    // System.out.println(event.toString());
    // } else {
    // System.out.println("ERROR FORMATING");
    // }
    // }
    // System.out.println(eventDayKB.toString());
    // }
    // return eventDayKB;
    // }
    //
    // /**
    // * Helper method to create either single-instance or recurring events. For
    // * simplicity, some values that might normally be passed as parameters
    // (such
    // * as author name, email, etc.) are hard-coded.
    // *
    // * @param service
    // * An authenticated CalendarService object.
    // * @param eventTitle
    // * Title of the event to create.
    // * @param eventContent
    // * Text content of the event to create.
    // * @param recurData
    // * Recurrence value for the event, or null for single-instance
    // * events.
    // * @param isQuickAdd
    // * True if eventContent should be interpreted as the text of a
    // * quick add event.
    // * @param wc
    // * A WebContent object, or null if this is not a web content
    // * event.
    // * @return The newly-created CalendarEventEntry.
    // * @throws ServiceException
    // * If the service is unable to handle the request.
    // * @throws IOException
    // * Error communicating with the server.
    // */
    // public static CalendarEventEntry createEvent(CalendarService service,
    // String eventTitle, String eventContent, String recurData,
    // boolean isQuickAdd, WebContent wc) throws ServiceException, IOException {
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
    //
    // public static CalendarEventEntry createDayEvent(String titre, String
    // eventContent, long date, String ville) throws ServiceException,
    // IOException {
    // CalendarEventEntry myEntry = new CalendarEventEntry();
    //
    // myEntry.setTitle(new PlainTextConstruct(titre));
    // myEntry.setContent(new PlainTextConstruct(eventContent));
    //
    // myEntry.getLocations().add(0, new Where(ville, ville, ville));
    // // myEntry.setQuickAdd(false);
    // // myEntry.setWebContent(wc);
    //
    // Calendar calendar = new GregorianCalendar();
    // calendar.setTime(new Date(date));
    //
    //
    // calendar.set(Calendar.HOUR, 0);
    // calendar.set(Calendar.MINUTE, 0);
    // calendar.set(Calendar.SECOND, 0);
    //
    //
    //
    // DateTime startTime = new DateTime(calendar.getTime(),
    // TimeZone.getDefault());
    // calendar.set(Calendar.DAY_OF_MONTH,
    // calendar.get(Calendar.DAY_OF_MONTH)+1);
    // // calendar.set(Calendar.HOUR, 23);
    // // calendar.set(Calendar.MINUTE, 59);
    // // calendar.set(Calendar.SECOND, 0);
    //
    // DateTime endTime = new DateTime(calendar.getTime(),
    // TimeZone.getDefault());
    //
    // When eventTimes = new When();
    // eventTimes.setStartTime(startTime);
    // eventTimes.setEndTime(endTime);
    // myEntry.addTime(eventTimes);
    //
    // // Send the request and receive the response:
    // return myService.insert(eventFeedUrl, myEntry);
    // }
    //
    // public static void updateDayEvent(CalendarEventEntry event, String titre,
    // String eventContent, long date, String ville) throws IOException,
    // ServiceException {
    //
    // event.setTitle(new PlainTextConstruct(titre));
    // event.setContent(new PlainTextConstruct(eventContent));
    // event.getLocations().add(0, new Where(ville, ville, ville));
    // // FIXME DATE
    // event.update();
    // }
    //
    // public static void updateEvent(EventKB eventKB) throws IOException,
    // ServiceException {
    // eventKB.getCalendarEventEntry().setTitle(new
    // PlainTextConstruct(getTitreFromEvent(eventKB)));
    // eventKB.getCalendarEventEntry().setContent(new
    // PlainTextConstruct(getCommentaireFromEvent(eventKB)));
    // eventKB.getCalendarEventEntry().addTime(getPeriodeFromEvent(eventKB));
    //
    // eventKB.getCalendarEventEntry().update();
    // }
    //
    // private static String getTitreFromEvent(EventKB eventKB) {
    // StringBuilder sbTitre = new StringBuilder();
    // sbTitre.append("#");
    // sbTitre.append(eventKB.getIdMatch());
    // sbTitre.append(" ");
    // sbTitre.append(eventKB.getEquipeBleu());
    // sbTitre.append(" - ");
    // sbTitre.append(eventKB.getEquipeGris());
    // sbTitre.append(" - ");
    // sbTitre.append(eventKB.getEquipeNoir());
    //
    // return sbTitre.toString();
    // }
    //
    // private static String getCommentaireFromEvent(EventKB eventKB) {
    // StringBuilder sbCommentaire = new StringBuilder();
    // sbCommentaire.append("M");
    // sbCommentaire.append("||");
    // sbCommentaire.append((eventKB.isHomme() ? "M" : "F"));
    // sbCommentaire.append("||");
    // sbCommentaire.append(eventKB.getEquipeBleu());
    // sbCommentaire.append("||");
    // sbCommentaire.append(eventKB.getEquipeGris());
    // sbCommentaire.append("||");
    // sbCommentaire.append(eventKB.getEquipeNoir());
    // sbCommentaire.append("||");
    // sbCommentaire.append(eventKB.getDebut());
    // sbCommentaire.append("||");
    // sbCommentaire.append(eventKB.getFin());
    // return sbCommentaire.toString();
    // }
    //
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
    //
    // public static CalendarEventEntry createEvent(EventKB eventKB) throws
    // IOException, ServiceException {
    // CalendarEventEntry myEntry = new CalendarEventEntry();
    //
    // myEntry.setTitle(new PlainTextConstruct(getTitreFromEvent(eventKB)));
    // myEntry.setContent(new
    // PlainTextConstruct(getCommentaireFromEvent(eventKB)));
    //
    // myEntry.addTime(getPeriodeFromEvent(eventKB));
    //
    // // Send the request and receive the response:
    // return myService.insert(eventFeedUrl, myEntry);
    // }
    //
}
