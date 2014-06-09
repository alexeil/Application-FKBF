package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleModifiableCalendar
    extends AbstractTableModel
{
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");

    private EventDayKB eventDayKB = new EventDayKB();

    private final String[] entetes = { "H début", "H fin", "Sexe", "ID", "Bleu", "Gris", "Noir" };

    public ModeleModifiableCalendar()
    {
        super();
        eventDayKB.setEvents(new ArrayList<EventKB>());

    }

    public int getRowCount()
    {
        return eventDayKB.getEvents().size();
    }

    public int getColumnCount()
    {
        return entetes.length;
    }

    public String getColumnName(int columnIndex)
    {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return eventDayKB.getEvents().get(rowIndex).getDebut();
            case 1:
                return eventDayKB.getEvents().get(rowIndex).getFin();
            case 2:
                return eventDayKB.getEvents().get(rowIndex).isHomme();
            case 3:
                return eventDayKB.getEvents().get(rowIndex).getIdMatch();
            case 4:
                return eventDayKB.getEvents().get(rowIndex).getEquipeBleu();
            case 5:
                return eventDayKB.getEvents().get(rowIndex).getEquipeGris();
            case 6:
                return eventDayKB.getEvents().get(rowIndex).getEquipeNoir();
            default:
                return null; // Ne devrait jamais arriver
        }
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return Long.class;
            case 1:
                return Long.class;
            case 2:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true; // Toutes les cellules éditables
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if(aValue != null)
        {
            switch(columnIndex)
            {

                case 0:
                    try
                    {
                        eventDayKB.getEvents().get(rowIndex).setDebut(timeformat.parse((String) aValue).getTime());
                    }
                    catch(ParseException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    try
                    {
                        eventDayKB.getEvents().get(rowIndex).setFin(timeformat.parse((String) aValue).getTime());
                    }
                    catch(ParseException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    eventDayKB.getEvents().get(rowIndex).setHomme((boolean) aValue);
                    break;
                case 3:
                    eventDayKB.getEvents().get(rowIndex).setIdMatch((String) aValue);
                    break;
                case 4:
                    eventDayKB.getEvents().get(rowIndex).setEquipeBleu((String) aValue);
                    break;
                case 5:
                    eventDayKB.getEvents().get(rowIndex).setEquipeGris((String) aValue);
                    break;
                case 6:
                    eventDayKB.getEvents().get(rowIndex).setEquipeNoir((String) aValue);
                    break;

            }
        }
    }

    public void addEvent(EventKB eventKB)
    {
        eventDayKB.getEvents().add(eventKB);

        fireTableRowsInserted(eventDayKB.getEvents().size() - 1, eventDayKB.getEvents().size() - 1);
    }

    public void removeTeam(int rowIndex)
    {
        eventDayKB.getEvents().remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void removeEventDayKB()
    {

        for(int rowIndex = 0; rowIndex < getRowCount() - 1; rowIndex++)
        {
            eventDayKB.getEvents().remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }

        eventDayKB = new EventDayKB();
    }

    public List<EventKB> getEventsKB()
    {
        return eventDayKB.getEvents();
    }

    public void setTeams(List<EventKB> events)
    {
        this.eventDayKB.setEvents(events);
    }
}