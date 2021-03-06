package main.java.dao;

import main.java.metier.Classement;
import main.java.metier.Parametres;
import main.java.metier.old.DivisionListeElement;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ClassementDAO  extends CommonDAO
{

    private final static Logger LOGGER = Logger.getLogger(ClassementDAO.class.getName());

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Classement findClassementByDivisionDateSexe(String division, Date date, String sexe) {

        Query query = session.createQuery(
                "SELECT c FROM "+ Classement.class.getName() + " c WHERE c.division = :division AND c.date = :date AND c.sexe = :sexe ")
                .setParameter("division", "D1")
                .setParameter("date", date)
                .setParameter("sexe", "F");
        return  (Classement)query.uniqueResult();
    }


    /**
     * Constructeur
     *//*
    public ClassementDAO()
    {
        this.connection = ConnectionBDD.getInstance();
    }

    public void deleteClassement(Classement classement)
    {
        Statement stm;
        StringBuilder requete = new StringBuilder();
        try
        {
            stm = connection.createStatement();
            requete.append("DELETE FROM classement WHERE  ");
            requete.append(" division = '" + classement.getPoule() + "' AND ");
            requete.append(" sexe ='" + classement.getSexe() + "' AND");
            requete.append(" date ='" + DATE_FORMAT.format(new Date(classement.getDate())) + "'");

            stm.executeUpdate(requete.toString());

            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            LOGGER.error(requete, e);
        }
    }

    public void insertClassement(Classement classement)
    {

        Statement stm;
        try
        {
            stm = connection.createStatement();

            StringBuilder requete = new StringBuilder();
            StringBuilder subRequete = new StringBuilder();

            requete
                .append(
                    "INSERT INTO classement  (  division , sexe , date ,  rang ,  logo ,  nom_equipe ,  points ,  match_joue , premiere_place ,  deuxieme_place ,  troisieme_place ,  forfait , nb_periode ,  esprit_sportif )");
            requete.append(" VALUES (");
            requete.append("'" + classement.getPoule() + "',");
            requete.append("'" + classement.getSexe() + "',");
            requete.append("'" + DATE_FORMAT.format(new Date(classement.getDate())) + "',");

            for(Team team : classement.getTeams())
            {
                subRequete = new StringBuilder();

                subRequete.append(requete);
                subRequete.append("'" + team.getRank() + "',");
                subRequete.append("'" + team.getLogo() + "',");
                subRequete.append("'" + team.getTeam() + "',");
                subRequete.append("'" + team.getPoints().replace("-", "0") + "',");
                subRequete.append("'" + team.getMj().replace("-", "0") + "',");
                subRequete.append("'" + team.getFirst().replace("-", "0") + "',");
                subRequete.append("'" + team.getSecond().replace("-", "0") + "',");
                subRequete.append("'" + team.getThird().replace("-", "0") + "',");
                subRequete.append("'" + team.getForfeit().replace("-", "0") + "',");
                subRequete.append("'" + team.getNbPeriodes().replace("-", "0") + "',");
                subRequete.append("'" + team.getFairPlay().replace("-", "0") + "')");

                System.out.println(subRequete.toString());
                stm.executeUpdate(subRequete.toString());
            }
            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public Classement selectAllClassement(long date, String sexe, String division)
    {

        Classement classement = new Classement();
        List<Team> teams = new ArrayList<Team>();

        StringBuilder requete = new StringBuilder();
        requete.append("SELECT * FROM CLASSEMENT");
        requete.append(" WHERE ");
        requete.append(" date ='" + DATE_FORMAT.format(new Date(date)) + "'  AND");
        requete.append(" sexe ='" + sexe + "' AND ");
        requete.append(" division ='" + division + "'");

        try
        {
            Statement stm = connection.createStatement();
            ResultSet resultat = stm.executeQuery(requete.toString());

            while(resultat.next())
            {

                classement.setDate(resultat.getDate("date").getTime());
                classement.setHomme(resultat.getString("sexe").equals('M') ? true : false);
                classement.setPoule(resultat.getString("division"));

                String rank = resultat.getString("rang");
                String logo = resultat.getString("logo");
                String sTeam = resultat.getString("nom_equipe");
                String points = resultat.getString("points");
                String mj = resultat.getString("match_joue");
                String first = resultat.getString("premiere_place");
                String second = resultat.getString("deuxieme_place");
                String third = resultat.getString("troisieme_place");
                String forfeit = resultat.getString("forfait");
                String nbPeriodes = resultat.getString("nb_periode");
                String fairPlay = resultat.getString("esprit_sportif");

                Team oTeam =
                    new Team(rank, logo, sTeam, points, mj, first, second, third, forfeit, nbPeriodes, fairPlay);
                teams.add(oTeam);
            }

            classement.setTeams(teams);

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

        return classement;
    }

    public List<DivisionListeElement> getAllDivision()
    {

        List<DivisionListeElement> DivisionListeElements = new ArrayList<DivisionListeElement>();

        String requete = "SELECT DISTINCT division, sexe FROM classement";

        try
        {
            Statement stm = connection.createStatement();
            ResultSet resultat = stm.executeQuery(requete);
            DivisionListeElement divisionListeElement;
            while(resultat.next())
            {
                divisionListeElement =
                    new DivisionListeElement(resultat.getString("division"), resultat.getString("sexe"));
                DivisionListeElements.add(divisionListeElement);
            }

            resultat.close();
            resultat = null;
            stm.close();
            stm = null;

        }
        catch(SQLException e)
        {
            LOGGER.debug("Error: queryColumns(): " + requete);
            LOGGER.error("Error", e);
        }

        return DivisionListeElements;
    }*/
}
