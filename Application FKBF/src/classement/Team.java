package classement;

public class Team
{

    public static String RN = "\r\n";

    private String rank;
    private String logo;
    private String team;
    private String points;
    private String mj;
    private String first;
    private String second;
    private String third;
    private String forfeit;
    private String nbPeriodes;
    private String fairPlay;

    public Team(String rank, String logo, String team, String points, String mj, String first, String second,
                String third, String forfeit, String nbPeriodes, String fairPlay)
    {
        super();

        this.rank = rank;
        this.logo = logo;
        this.team = team;
        this.points = points;
        this.mj = mj;
        this.first = first;
        this.second = second;
        this.third = third;
        this.forfeit = forfeit;
        this.nbPeriodes = nbPeriodes;
        this.fairPlay = fairPlay;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("-----------------------------------" + RN);
        sb.append("rank =" + rank + RN);
        sb.append("logo =" + logo + RN);
        sb.append("team = " + team + RN);
        sb.append("points = " + points + RN);
        sb.append("mj = " + mj + RN);
        sb.append("first = " + first + RN);
        sb.append("second = " + second + RN);
        sb.append("third = " + third + RN);
        sb.append("forfeit = " + forfeit + RN);
        sb.append("nbPeriodes = " + nbPeriodes + RN);
        sb.append("fairPlay = " + fairPlay + RN);
        sb.append("-----------------------------------" + RN);

        // System.out.println(sb.toString());

        return sb.toString();
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public String getLogo()
    {
        return logo;
    }

    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getPoints()
    {
        return points;
    }

    public void setPoints(String points)
    {
        this.points = points;
    }

    public String getMj()
    {
        return mj;
    }

    public void setMj(String mj)
    {
        this.mj = mj;
    }

    public String getFirst()
    {
        return first;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public String getSecond()
    {
        return second;
    }

    public void setSecond(String second)
    {
        this.second = second;
    }

    public String getThird()
    {
        return third;
    }

    public void setThird(String third)
    {
        this.third = third;
    }

    public String getForfeit()
    {
        return forfeit;
    }

    public void setForfeit(String forfeit)
    {
        this.forfeit = forfeit;
    }

    public String getNbPeriodes()
    {
        return nbPeriodes;
    }

    public void setNbPeriodes(String nbPeriodes)
    {
        this.nbPeriodes = nbPeriodes;
    }

    public String getFairPlay()
    {
        return fairPlay;
    }

    public void setFairPlay(String fairPlay)
    {
        this.fairPlay = fairPlay;
    }

}