package src.main.java.metier;

public class DivisionListeElement
{

    private String division;
    private String sexe;

    public DivisionListeElement(String division, String sexe)
    {
        super();
        this.division = division;
        this.sexe = sexe;
    }

    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    public String getSexe()
    {
        return sexe;
    }

    public void setSexe(String sexe)
    {
        this.sexe = sexe;
    }

    @Override
    public String toString()
    {
        return division + " - " + (sexe.equals("M") ? "Masculin" : "F�minin");
    }

}
