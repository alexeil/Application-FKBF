package metier;

public class Match
{

    private int id;
    private String idMatch;
    private Equipe bleu;
    private Equipe gris;
    private Equipe noir;
    private String arbitreChef;
    private String arbitreAdjoint;

    public Match(int id, String id_match, Equipe bleu, Equipe gris, Equipe noir, String arbitreChef,
                 String arbitreAdjoint)
    {
        super();
        this.id = id;
        this.idMatch = id_match;
        this.bleu = bleu;
        this.gris = gris;
        this.noir = noir;
        this.arbitreChef = arbitreChef;
        this.arbitreAdjoint = arbitreAdjoint;
    }

    public Match(String id_match, Equipe bleu, Equipe gris, Equipe noir, String arbitreChef, String arbitreAdjoint)
    {
        super();
        this.idMatch = id_match;
        this.bleu = bleu;
        this.gris = gris;
        this.noir = noir;
        this.arbitreChef = arbitreChef;
        this.arbitreAdjoint = arbitreAdjoint;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIdMatch()
    {
        return idMatch;
    }

    public void setIdMatch(String idMatch)
    {
        this.idMatch = idMatch;
    }

    public Equipe getBleu()
    {
        return bleu;
    }

    public void setBleu(Equipe bleu)
    {
        this.bleu = bleu;
    }

    public Equipe getGris()
    {
        return gris;
    }

    public void setGris(Equipe gris)
    {
        this.gris = gris;
    }

    public Equipe getNoir()
    {
        return noir;
    }

    public void setNoir(Equipe noir)
    {
        this.noir = noir;
    }

    public String getArbitreChef()
    {
        return arbitreChef;
    }

    public void setArbitreChef(String arbitreChef)
    {
        this.arbitreChef = arbitreChef;
    }

    public String getArbitreAdjoint()
    {
        return arbitreAdjoint;
    }

    public void setArbitreAdjoint(String arbitreAdjoint)
    {
        this.arbitreAdjoint = arbitreAdjoint;
    }
}
