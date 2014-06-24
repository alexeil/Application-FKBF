package main.java.classement;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModeleModifiable
    extends AbstractTableModel
{
    private List<Team> teams = new ArrayList<Team>();

    private final String[] entetes = { "Rang", "Logo", "Equipe", "Points", "MJ", "1�re place", "2�me place",
        "3�me place", "Forfait", "Nb P�riodes", "Esprit sportif" };

    public ModeleModifiable()
    {
        super();
    }

    public int getRowCount()
    {
        return teams.size();
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
                return teams.get(rowIndex).getRank();
            case 1:
                return teams.get(rowIndex).getLogo();
            case 2:
                return teams.get(rowIndex).getTeam();
            case 3:
                return teams.get(rowIndex).getPoints();
            case 4:
                return teams.get(rowIndex).getMj();
            case 5:
                return teams.get(rowIndex).getFirst();
            case 6:
                return teams.get(rowIndex).getSecond();
            case 7:
                return teams.get(rowIndex).getThird();
            case 8:
                return teams.get(rowIndex).getForfeit();
            case 9:
                return teams.get(rowIndex).getNbPeriodes();
            case 10:
                return teams.get(rowIndex).getFairPlay();
            default:
                return null; // Ne devrait jamais arriver
        }
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true; // Toutes les cellules �ditables
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if(aValue != null)
        {
            Team team = teams.get(rowIndex);

            switch(columnIndex)
            {

                case 0:
                    team.setRank((String) aValue);
                    break;
                case 1:
                    team.setLogo((String) aValue);
                    break;
                case 2:
                    team.setTeam((String) aValue);
                    break;
                case 3:
                    team.setPoints((String) aValue);
                    break;
                case 4:
                    team.setMj((String) aValue);
                    break;
                case 5:
                    team.setFirst((String) aValue);
                    break;
                case 6:
                    team.setSecond((String) aValue);
                    break;
                case 7:
                    team.setThird((String) aValue);
                    break;
                case 8:
                    team.setForfeit((String) aValue);
                    break;
                case 9:
                    team.setNbPeriodes((String) aValue);
                    break;
                case 10:
                    team.setFairPlay((String) aValue);
                    break;

            }
        }
    }

    public void addTeam(Team team)
    {
        teams.add(team);

        fireTableRowsInserted(teams.size() - 1, teams.size() - 1);
    }

    public void removeTeam(int rowIndex)
    {
        teams.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public List<Team> getTeams()
    {
        return teams;
    }

    public void setTeams(List<Team> teams)
    {
        this.teams = teams;
    }

    public void orderTeams()
    {
        Collections.sort(teams, new Comparator<Team>()
        {
            @Override
            public int compare(Team arg0, Team arg1)
            {
                return arg0.getRank().compareTo(arg1.getRank());
            }
        });
    }
}