package metier;

import java.sql.Date;

public class Classement
{

    private int idClassement;
    private Date date;
    private String division;
    private String html;

    public Classement(int idClassement, Date date, String division, String html)
    {
        super();
        this.idClassement = idClassement;
        this.date = date;
        this.division = division;
        this.html = html;
    }

    public Classement()
    {

    }

    @Override
    public String toString()
    {
        return "Classement [idClassement=" + idClassement + ", date=" + date + ", division=" + division + ", html="
            + html + "]";
    }

    public int getIdClassement()
    {
        return idClassement;
    }

    public void setIdClassement(int idClassement)
    {
        this.idClassement = idClassement;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    public String getHtml()
    {
        return html;
    }

    public void setHtml(String html)
    {
        this.html = html;
    }

}
