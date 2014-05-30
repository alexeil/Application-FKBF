package calendar;

import java.sql.Time;

import com.google.api.services.calendar.model.Event;
import com.google.gdata.data.calendar.CalendarEventEntry;

public class EventKB {

	private long debut;
	private long fin;
	private boolean isHomme;
	private String equipeBleu;
	private String equipeGris;
	private String equipeNoir;
	private Event calendarEventEntry;
	private String idMatch;
	public EventKB() {
		super();
	}
	
	public EventKB(long heure, boolean isHomme, String equipeBleu, String equipeGris, String equipeNoir) {
		super();
		this.debut = heure;
		this.isHomme = isHomme;
		this.equipeBleu = equipeBleu;
		this.equipeGris = equipeGris;
		this.equipeNoir = equipeNoir;
	}
	
	@Override
	public String toString() {
		return "EventKB [debut=" + debut + ", fin=" + fin + ", isHomme=" + isHomme + ", equipeBleu=" + equipeBleu + ", equipeGris=" + equipeGris
				+ ", equipeNoir=" + equipeNoir + ", calendarEventEntry=" + calendarEventEntry + ", idMatch=" + idMatch + "]";
	}

	public Event getCalendarEventEntry() {
		return calendarEventEntry;
	}

	public void setCalendarEventEntry(Event entry) {
		this.calendarEventEntry = entry;
	}
	
	public long getDebut() {
		return debut;
	}
	public void setDebut(long heure) {
		this.debut = heure;
	}
	public boolean isHomme() {
		return isHomme;
	}
	public void setHomme(boolean isHomme) {
		this.isHomme = isHomme;
	}
	public String getEquipeBleu() {
		return equipeBleu;
	}
	public void setEquipeBleu(String equipeBleu) {
		this.equipeBleu = equipeBleu;
	}
	public String getEquipeGris() {
		return equipeGris;
	}
	public void setEquipeGris(String equipeGris) {
		this.equipeGris = equipeGris;
	}
	public String getEquipeNoir() {
		return equipeNoir;
	}
	public void setEquipeNoir(String equipeNoir) {
		this.equipeNoir = equipeNoir;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

	public String getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(String idMatch) {
		this.idMatch = idMatch;
	}

}
