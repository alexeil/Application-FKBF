package main.java.metier;

public class Equipe
{
    private int id_equipe;
    private String color;
    private String nomEquipe;
    private boolean isForfait;
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;
    private int p6;
    private int p7;
    private int prol1;
    private int prol2;
    private int prol3;
    private int prol4;
    private int prol5;
    private int prol6;
    private int prol7;
    private int prol_deuxieme;
    private int nb_periode;
    private int esprit_sportif;
    private int points;

    public Equipe()
    {

    }

    public Equipe(int id_equipe, String color, String nomEquipe, boolean isForfait, int p1, int p2, int p3, int p4,
                  int p5, int p6, int p7, int prol1, int prol2, int prol3, int prol4, int prol5, int prol6, int prol7,
                  int prol_deuxieme, int nb_periode, int esprit_sportif, int points)
    {
        super();
        this.id_equipe = id_equipe;
        this.color = color;
        this.nomEquipe = nomEquipe;
        this.isForfait = isForfait;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.prol1 = prol1;
        this.prol2 = prol2;
        this.prol3 = prol3;
        this.prol4 = prol4;
        this.prol5 = prol5;
        this.prol6 = prol6;
        this.prol7 = prol7;
        this.prol_deuxieme = prol_deuxieme;
        this.nb_periode = nb_periode;
        this.esprit_sportif = esprit_sportif;
        this.points = points;
    }

    public Equipe(String color, String nomEquipe, boolean isForfait, String p1, String p2, String p3, String p4,
                  String p5, String p6, String p7, String prol1, String prol2, String prol3, String prol4,
                  String prol5, String prol6, String prol7, String prol_deuxieme, String nb_periode,
                  String esprit_sportif, String points)
    {
        super();
        this.color = color;
        this.nomEquipe = nomEquipe;
        this.isForfait = isForfait;

        if(p1 == null || p1.equals(""))
        {
            this.p1 = 0;
        }
        else
        {
            this.p1 = Integer.parseInt(p1);
        }

        if(p2 == null || p2.equals(""))
        {
            this.p2 = 0;
        }
        else
        {
            this.p2 = Integer.parseInt(p2);
        }

        if(p3 == null || p3.equals(""))
        {
            this.p3 = 0;
        }
        else
        {
            this.p3 = Integer.parseInt(p3);
        }
        if(p4 == null || p4.equals(""))
        {
            this.p4 = 0;
        }
        else
        {
            this.p4 = Integer.parseInt(p4);
        }
        if(p5 == null || p5.equals(""))
        {
            this.p5 = 0;
        }
        else
        {
            this.p5 = Integer.parseInt(p5);
        }
        if(p6 == null || p6.equals(""))
        {
            this.p6 = 0;
        }
        else
        {
            this.p6 = Integer.parseInt(p6);
        }
        if(p7 == null || p7.equals(""))
        {
            this.p7 = 0;
        }
        else
        {
            this.p7 = Integer.parseInt(p7);
        }

        if(prol1 == null || prol1.equals(""))
        {
            this.prol1 = 0;
        }
        else
        {
            this.prol1 = Integer.parseInt(prol1);
        }
        if(prol2 == null || prol2.equals(""))
        {
            this.prol2 = 0;
        }
        else
        {
            this.prol2 = Integer.parseInt(prol2);
        }
        if(prol3 == null || prol3.equals(""))
        {
            this.prol3 = 0;
        }
        else
        {
            this.prol3 = Integer.parseInt(prol3);
        }
        if(prol4 == null || prol4.equals(""))
        {
            this.prol4 = 0;
        }
        else
        {
            this.prol4 = Integer.parseInt(prol4);
        }
        if(prol5 == null || prol5.equals(""))
        {
            this.prol5 = 0;
        }
        else
        {
            this.prol5 = Integer.parseInt(prol5);
        }
        if(prol6 == null || prol6.equals(""))
        {
            this.prol6 = 0;
        }
        else
        {
            this.prol6 = Integer.parseInt(prol6);
        }
        if(prol7 == null || prol7.equals(""))
        {
            this.prol7 = 0;
        }
        else
        {
            this.prol7 = Integer.parseInt(prol7);
        }
        if(prol_deuxieme == null || prol_deuxieme.equals(""))
        {
            this.prol_deuxieme = 0;
        }
        else
        {
            this.prol_deuxieme = Integer.parseInt(prol_deuxieme);
        }
        if(nb_periode == null || nb_periode.equals(""))
        {
            this.nb_periode = 0;
        }
        else
        {
            this.nb_periode = Integer.parseInt(nb_periode);
        }
        if(esprit_sportif == null || esprit_sportif.equals(""))
        {
            this.esprit_sportif = 0;
        }
        else
        {
            this.esprit_sportif = Integer.parseInt(esprit_sportif);
        }
        if(points == null || points.equals(""))
        {
            this.points = 0;
        }
        else
        {
            this.points = Integer.parseInt(points);
        }
    }

    public int getId_equipe()
    {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe)
    {
        this.id_equipe = id_equipe;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isForfait()
    {
        return isForfait;
    }

    public void setForfait(boolean isForfait)
    {
        this.isForfait = isForfait;
    }

    public int getP1()
    {
        return p1;
    }

    public void setP1(int p1)
    {
        this.p1 = p1;
    }

    public int getP2()
    {
        return p2;
    }

    public void setP2(int p2)
    {
        this.p2 = p2;
    }

    public int getP3()
    {
        return p3;
    }

    public void setP3(int p3)
    {
        this.p3 = p3;
    }

    public int getP4()
    {
        return p4;
    }

    public void setP4(int p4)
    {
        this.p4 = p4;
    }

    public int getP5()
    {
        return p5;
    }

    public void setP5(int p5)
    {
        this.p5 = p5;
    }

    public int getP6()
    {
        return p6;
    }

    public void setP6(int p6)
    {
        this.p6 = p6;
    }

    public int getP7()
    {
        return p7;
    }

    public void setP7(int p7)
    {
        this.p7 = p7;
    }

    public int getProl1()
    {
        return prol1;
    }

    public void setProl1(int prol1)
    {
        this.prol1 = prol1;
    }

    public int getProl2()
    {
        return prol2;
    }

    public void setProl2(int prol2)
    {
        this.prol2 = prol2;
    }

    public int getProl3()
    {
        return prol3;
    }

    public void setProl3(int prol3)
    {
        this.prol3 = prol3;
    }

    public int getProl4()
    {
        return prol4;
    }

    public void setProl4(int prol4)
    {
        this.prol4 = prol4;
    }

    public int getProl5()
    {
        return prol5;
    }

    public void setProl5(int prol5)
    {
        this.prol5 = prol5;
    }

    public int getProl6()
    {
        return prol6;
    }

    public void setProl6(int prol6)
    {
        this.prol6 = prol6;
    }

    public int getProl7()
    {
        return prol7;
    }

    public void setProl7(int prol7)
    {
        this.prol7 = prol7;
    }

    public int getProl_deuxieme()
    {
        return prol_deuxieme;
    }

    public void setProl_deuxieme(int prol_deuxieme)
    {
        this.prol_deuxieme = prol_deuxieme;
    }

    public int getNb_periode()
    {
        return nb_periode;
    }

    public void setNb_periode(int nb_periode)
    {
        this.nb_periode = nb_periode;
    }

    public int getEsprit_sportif()
    {
        return esprit_sportif;
    }

    public void setEsprit_sportif(int esprit_sportif)
    {
        this.esprit_sportif = esprit_sportif;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String getNomEquipe()
    {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe)
    {
        this.nomEquipe = nomEquipe;
    }

}
