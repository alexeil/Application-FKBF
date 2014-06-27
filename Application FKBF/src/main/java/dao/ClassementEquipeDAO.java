package main.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.metier.old.Classement;

public class ClassementEquipeDAO extends CommonDAO
{

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructeur
     *//*
    public ClassementHtmlDAO()
    {
        this.connection = ConnectionBDD.getInstance();
    }

    public void deleteClassementHtml(main.java.classement.Classement classement)
    {
        Statement stm;
        try
        {
            stm = connection.createStatement();

            StringBuilder requete = new StringBuilder();

            requete.append("DELETE FROM classement_Html WHERE  ");
            requete.append(" division = '" + classement.getPoule() + "' AND ");
            requete.append(" sexe ='" + classement.getSexe() + "' AND");
            requete.append(" date ='" + DATE_FORMAT.format(new Date(classement.getDate())) + "'");

            stm.executeUpdate(requete.toString());

            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void insertClassement(main.java.classement.Classement classement, StringBuilder html)
    {

        Statement stm;
        try
        {
            stm = connection.createStatement();

            StringBuilder requete = new StringBuilder();

            requete.append("INSERT INTO classement_Html  (  division , sexe , date , html )");
            requete.append(" VALUES (");
            requete.append("'" + classement.getPoule() + "',");
            requete.append("'" + classement.getSexe() + "',");
            requete.append("'" + DATE_FORMAT.format(new Date(classement.getDate())) + "',");
            requete.append("'" + html.toString() + "' )");

            System.out.println(requete.toString());
            stm.executeUpdate(requete.toString());
            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void selectClassement()
    {
        String requete = "SELECT * FROM CLASSEMENT_HTML";

        try
        {
            Statement stm = connection.createStatement();
            ResultSet resultat = stm.executeQuery(requete);

            while(resultat.next())
            {
                Classement classement = new Classement();

                classement.setDate(resultat.getDate("date"));
                classement.setDivision(resultat.getString("division"));
                classement.setHtml(resultat.getString("html"));
                classement.setIdClassement(resultat.getInt("id_classement"));

                System.out.println(classement.toString());
            }

            resultat.close();
            resultat = null;
            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            System.err.println("Error: queryColumns(): " + requete);
            e.printStackTrace();
        }
    }*/
}
