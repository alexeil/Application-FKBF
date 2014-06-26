package main.java.metier;

/**
 * MatchHtml generated by hbm2java
 */
public class MatchHtml
    implements java.io.Serializable
{

    private Integer idMatch;
    private Match match;
    private String html;

    public MatchHtml()
    {
    }

    public MatchHtml(Match match, String html)
    {
        this.match = match;
        this.html = html;
    }

    public Integer getIdMatch()
    {
        return this.idMatch;
    }

    public void setIdMatch(Integer idMatch)
    {
        this.idMatch = idMatch;
    }

    public Match get()
    {
        return this.match;
    }

    public void setMatch(Match match)
    {
        this.match = match;
    }

    public String getHtml()
    {
        return this.html;
    }

    public void setHtml(String html)
    {
        this.html = html;
    }

    public Match getMatch()
    {
        return match;
    }
}