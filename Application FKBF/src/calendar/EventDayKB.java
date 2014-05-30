package calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.services.calendar.model.Event;
import com.google.gdata.data.calendar.CalendarEventEntry;

public class EventDayKB {

	private List<EventKB> events;
	private long date;
	private String titre;
	private String ville;
	private Event calendarEventEntry;
	
	public EventDayKB(List<EventKB> events, long date, String titre, String ville) {
		super();
		this.events = events;
		this.date = date;
		this.titre = titre;
		this.ville =  ville;
	}
	
	public EventDayKB() {
		this.events = new ArrayList<EventKB>();
	}

	@Override
	public String toString() {
		return "EventDayKB [events=" + events + ", date=" + date + ", titre=" + titre + ", ville=" + ville + "]";
	}

	public List<EventKB> getEvents() {
		return events;
	}
	public void setEvents(List<EventKB> events) {
		this.events = events;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long l) {
		this.date = l;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Event getCalendarEventEntry() {
		return calendarEventEntry;
	}

	public void setCalendarEventEntry(Event entry) {
		this.calendarEventEntry = entry;
	}

}
