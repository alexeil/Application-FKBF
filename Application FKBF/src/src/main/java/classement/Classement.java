package src.main.java.classement;

import java.util.List;

public class Classement
{

    String poule;

    List<Team> teams;
    private long date;
    private boolean isHomme;

    public Classement(String poule, List<Team> teams, long date, boolean isHomme)
    {
        super();
        this.poule = poule;
        this.teams = teams;
        this.date = date;
        this.isHomme = isHomme;
    }

    public Classement(String poule, List<Team> teams)
    {
        super();
        this.poule = poule;
        this.teams = teams;
    }

    public Classement()
    {

    }

    public String getPoule()
    {
        return poule;
    }

    public void setPoule(String poule)
    {
        this.poule = poule;
    }

    public List<Team> getTeams()
    {
        return teams;
    }

    public void setTeams(List<Team> teams)
    {
        this.teams = teams;
    }

    public long getDate()
    {
        return date;
    }

    public void setDate(long date)
    {
        this.date = date;
    }

    public boolean isHomme()
    {
        return isHomme;
    }

    public char getSexe()
    {
        return isHomme ? 'M' : 'F';
    }

    public void setHomme(boolean isHomme)
    {
        this.isHomme = isHomme;
    }

}
