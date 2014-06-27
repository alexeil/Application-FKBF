package main.java.classement;

import main.java.metier.ClassementEquipe;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModeleModifiable
    extends AbstractTableModel
{
    private List<ClassementEquipe> teams = new ArrayList<ClassementEquipe>();

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
                return teams.get(rowIndex).getRang();
            case 1:
                return teams.get(rowIndex).getLogo();
            case 2:
                return teams.get(rowIndex).getNomEquipe();
            case 3:
                return teams.get(rowIndex).getPoints();
            case 4:
                return teams.get(rowIndex).getMatchJoue();
            case 5:
                return teams.get(rowIndex).getPremierePlace();
            case 6:
                return teams.get(rowIndex).getDeuxiemePlace();
            case 7:
                return teams.get(rowIndex).getTroisiemePlace();
            case 8:
                return teams.get(rowIndex).getForfait();
            case 9:
                return teams.get(rowIndex).getNbPeriode();
            case 10:
                return teams.get(rowIndex).getEspritSportif();
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
            ClassementEquipe team = teams.get(rowIndex);

            switch(columnIndex)
            {

                case 0:
                    team.setRang((String) aValue);
                    break;
                case 1:
                    team.setLogo((String) aValue);
                    break;
                case 2:
                    team.setNomEquipe((String) aValue);
                    break;
                case 3:
                    team.setPoints((String) aValue);
                    break;
                case 4:
                    team.setMatchJoue((String) aValue);
                    break;
                case 5:
                    team.setPremierePlace((String) aValue);
                    break;
                case 6:
                    team.setDeuxiemePlace((String) aValue);
                    break;
                case 7:
                    team.setTroisiemePlace((String) aValue);
                    break;
                case 8:
                    team.setForfait((String) aValue);
                    break;
                case 9:
                    team.setNbPeriode((String) aValue);
                    break;
                case 10:
                    team.setEspritSportif((String) aValue);
                    break;

            }
        }
    }

    public void addTeam(ClassementEquipe team)
    {
        teams.add(team);

        fireTableRowsInserted(teams.size() - 1, teams.size() - 1);
    }

    public void removeTeam(int rowIndex)
    {
        teams.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public List<ClassementEquipe> getTeams()
    {
        return teams;
    }

    public void setTeams(List<ClassementEquipe> teams)
    {
        this.teams = teams;
    }

    public void orderTeams()
    {
        Collections.sort(teams, new Comparator<ClassementEquipe>()
        {
            @Override
            public int compare(ClassementEquipe arg0, ClassementEquipe arg1)
            {
                return arg0.getRang().compareTo(arg1.getRang());
            }
        });
    }
}