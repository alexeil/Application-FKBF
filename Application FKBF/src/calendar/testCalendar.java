package calendar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.google.gdata.client.calendar.CalendarQuery;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.data.calendar.WebContent;
import com.google.gdata.data.extensions.Recurrence;
import com.google.gdata.data.extensions.When;
import com.google.gdata.util.ServiceException;

public class testCalendar
{
    // The base URL for a user's calendar metafeed (needs a username appended).
    private static final String METAFEED_URL_BASE = "https://www.google.com/calendar/feeds/";

    // The string to add to the user's metafeedUrl to access the event feed for
    // their primary calendar.
    private static final String EVENT_FEED_URL_SUFFIX = "/private/full";

    // The URL for the metafeed of the specified user.
    // (e.g. http://www.google.com/feeds/calendar/jdoe@gmail.com)
    private static URL metafeedUrl = null;

    // The URL for the event feed of the specified user's primary calendar.
    // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
    private static URL eventFeedUrl = null;

    /**
     * @param args
     * @throws ServiceException
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args)
        throws IOException, ServiceException, ParseException
    {
        String calendar = "7m7f052020pvc2ef8pfg2dsia0@group.calendar.google.com";
        CalendarService myService = new CalendarService(calendar);

        String userName = "fkbf@kin-ball.fr";
        String userPassword = "22kin35ball49";
        // Create the necessary URL objects.
        try
        {
            metafeedUrl = new URL(METAFEED_URL_BASE + userName);
            eventFeedUrl = new URL(METAFEED_URL_BASE + calendar + EVENT_FEED_URL_SUFFIX);
        }
        catch(MalformedURLException e)
        {
            // Bad URL
            System.err.println("Uh oh - you've got an invalid URL.");
            e.printStackTrace();
            return;
        }
        System.out.println("metafeedUrl" + metafeedUrl);
        System.out.println("eventFeedUrl" + eventFeedUrl);
        myService.setUserCredentials(userName, userPassword);

        // Demonstrate retrieving a list of the user's calendars.
        // printUserCalendars(myService);
        // printAllEvents(myService);
        // DateTime debut = DateTime.parseDate("2013-12-15");
        // DateTime fin = DateTime.parseDate("2013-12-16");
        // dateRangeQuery(myService, debut, fin);

        // Demonstrate creating a single-occurrence event.
        CalendarEventEntry singleEvent = createSingleEvent(myService, "Tennis with Mike", "Meet for a quick lesson.");
        System.out.println("Successfully created event " + singleEvent.getTitle().getPlainText());

    }

    /**
     * Prints the titles of all events on the calendar specified by {@code feedUri}.
     * 
     * @param service An authenticated CalendarService object.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     */
    private static void printAllEvents(CalendarService service)
        throws ServiceException, IOException
    {
        // Send the request and receive the response:
        CalendarEventFeed resultFeed = service.getFeed(eventFeedUrl, CalendarEventFeed.class);

        System.out.println("All events on your calendar:");
        System.out.println();
        for(int i = 0; i < resultFeed.getEntries().size(); i++)
        {
            CalendarEventEntry entry = resultFeed.getEntries().get(i);
            System.out.println("\t" + entry.getTitle().getPlainText());

            List<com.google.gdata.data.extensions.When> whens = entry.getTimes();

            for(com.google.gdata.data.extensions.When when : whens)
            {
                System.out.println(when.getStartTime() + " to " + when.getEndTime());
            }
        }
        System.out.println("end --->");
    }

    /**
     * Prints a list of all the user's calendars.
     * 
     * @param service An authenticated CalendarService object.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server
     */
    private static void printUserCalendars(CalendarService service)
        throws IOException, ServiceException
    {
        // Send the request and receive the response:
        CalendarFeed resultFeed = service.getFeed(metafeedUrl, CalendarFeed.class);

        System.out.println("Your calendars:");
        System.out.println();
        for(int i = 0; i < resultFeed.getEntries().size(); i++)
        {
            CalendarEntry entry = resultFeed.getEntries().get(i);
            System.out.println("\t" + entry.getTitle().getPlainText() + " --- > " + entry.getId());
        }
        System.out.println();
    }

    /**
     * Prints the titles of all events in a specified date/time range.
     * 
     * @param service An authenticated CalendarService object.
     * @param startTime Start time (inclusive) of events to print.
     * @param endTime End time (exclusive) of events to print.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     * @throws ParseException
     */
    private static void dateRangeQuery(CalendarService service, DateTime startTime, DateTime endTime)
        throws ServiceException, IOException, ParseException
    {

        EventDayKB eventDayKB = new EventDayKB();

        List<EventKB> events = new ArrayList<EventKB>();
        eventDayKB.setEvents(events);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        CalendarQuery myQuery = new CalendarQuery(eventFeedUrl);
        myQuery.setMinimumStartTime(startTime);
        myQuery.setMaximumStartTime(endTime);

        // Send the request and receive the response:
        CalendarEventFeed resultFeed = service.query(myQuery, CalendarEventFeed.class);

        System.out.println("Events from " + startTime.toString() + " to " + endTime.toString() + ":");
        System.out.println();
        for(int i = 0; i < resultFeed.getEntries().size(); i++)
        {

            EventKB event = new EventKB();

            CalendarEventEntry entry = resultFeed.getEntries().get(i);
            // event.setCalendarEventEntry(entry);

            List<com.google.gdata.data.extensions.When> whens = entry.getTimes();
            event.setDebut(whens.get(0).getStartTime().getValue());
            event.setFin(whens.get(0).getEndTime().getValue());

            String commentaire = entry.getPlainTextContent();
            String[] values = commentaire.split("\\|\\|");

            // MATCH
            if("M".equals(values[0]))
            {
                event.setHomme("M".equals(values[1]) ? true : false);
                event.setIdMatch(values[2]);
                event.setEquipeBleu(values[3]);
                event.setEquipeGris(values[4]);
                event.setEquipeNoir(values[5]);
                System.out.println(event.toString());
                // JOURNEE
            }
            else if(null == commentaire || "".equals(commentaire))
            {
                eventDayKB.setDate(whens.get(0).getStartTime().getValue());
                eventDayKB.setVille(entry.getLocations().get(0).getValueString());
                eventDayKB.setTitre(entry.getTitle().getPlainText());
                System.out.println(event.toString());
            }
            else
            {
                System.out.println("ERROR FORMATING");

            }
            events.add(event);
            // for (com.google.gdata.data.extensions.When when : whens) {
            // if (entry.getTitle().getPlainText().contains("championnat")) {
            // System.out.println(" titre : " +
            // entry.getTitle().getPlainText());
            // System.out.println(" ville : " +
            // entry.getLocations().get(0).getValueString());
            // System.out.println(" Jour : " +
            // dateformat.format(when.getStartTime().getValue()));
            // } else {
            // System.out.println("heure : " +
            // timeformat.format(when.getStartTime().getValue()) + " to "
            // + timeformat.format(when.getEndTime().getValue()));
            // }
            // }
            // if (!entry.getTitle().getPlainText().contains("championnat")) {
            // System.out.println("\t" + entry.getTitle().getPlainText());
            // System.out.println("Commentaire : " +
            // entry.getPlainTextContent());
            // }

        }
        System.out.println();
        System.out.println(eventDayKB.toString());
    }

    /**
     * Creates a single-occurrence event.
     * 
     * @param service An authenticated CalendarService object.
     * @param eventTitle Title of the event to create.
     * @param eventContent Text content of the event to create.
     * @return The newly-created CalendarEventEntry.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     */
    private static CalendarEventEntry createSingleEvent(CalendarService service, String eventTitle, String eventContent)
        throws ServiceException, IOException
    {
        return createEvent(service, eventTitle, eventContent, null, false, null);
    }

    /**
     * Helper method to create either single-instance or recurring events. For simplicity, some values that might
     * normally be passed as parameters (such as author name, email, etc.) are hard-coded.
     * 
     * @param service An authenticated CalendarService object.
     * @param eventTitle Title of the event to create.
     * @param eventContent Text content of the event to create.
     * @param recurData Recurrence value for the event, or null for single-instance events.
     * @param isQuickAdd True if eventContent should be interpreted as the text of a quick add event.
     * @param wc A WebContent object, or null if this is not a web content event.
     * @return The newly-created CalendarEventEntry.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     */
    private static CalendarEventEntry createEvent(CalendarService service, String eventTitle, String eventContent,
                                                  String recurData, boolean isQuickAdd, WebContent wc)
        throws ServiceException, IOException
    {
        CalendarEventEntry myEntry = new CalendarEventEntry();

        myEntry.setTitle(new PlainTextConstruct(eventTitle));
        myEntry.setContent(new PlainTextConstruct(eventContent));
        myEntry.setQuickAdd(isQuickAdd);
        myEntry.setWebContent(wc);

        // If a recurrence was requested, add it. Otherwise, set the
        // time (the current date and time) and duration (30 minutes)
        // of the event.
        if(recurData == null)
        {
            Calendar calendar = new GregorianCalendar();
            DateTime startTime = new DateTime(calendar.getTime(), TimeZone.getDefault());

            calendar.add(Calendar.MINUTE, 30);
            DateTime endTime = new DateTime(calendar.getTime(), TimeZone.getDefault());

            When eventTimes = new When();
            eventTimes.setStartTime(startTime);
            eventTimes.setEndTime(endTime);
            myEntry.addTime(eventTimes);
        }
        else
        {
            Recurrence recur = new Recurrence();
            recur.setValue(recurData);
            myEntry.setRecurrence(recur);
        }

        // Send the request and receive the response:
        return service.insert(eventFeedUrl, myEntry);
    }

}
