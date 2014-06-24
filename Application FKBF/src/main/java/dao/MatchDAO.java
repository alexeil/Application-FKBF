package main.java.dao;

import main.java.metier.old.Equipe;
import main.java.metier.old.Match;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO
    extends CommonDAO
{
    private final static Logger LOGGER = Logger.getLogger(MatchDAO.class.getName());

    private Connection connection;

    /**
     * Constructeur
     */
    public MatchDAO()
    {
        this.connection = ConnectionBDD.getInstance();
    }

    public void save(Match match, StringBuilder html)
    {
        Statement stm;
        StringBuilder requete = new StringBuilder();
        try
        {
            stm = connection.createStatement();

            EquipeDAO equipeDAO = new EquipeDAO();

            Equipe bleu = match.getBleu();
            Equipe gris = match.getGris();
            Equipe noir = match.getNoir();

            int idBleu = equipeDAO.save(bleu);
            int idGris = equipeDAO.save(gris);
            int idNoir = equipeDAO.save(noir);

            requete.append("INSERT INTO `match` (id_match, bleu, gris, noir, arbitre_chef, arbitre_adjoint)");
            requete.append(" VALUES (");
            requete.append("'" + match.getIdMatch() + "',");
            requete.append("" + idBleu + ",");
            requete.append("" + idGris + ",");
            requete.append("" + idNoir + ",");
            requete.append("'" + match.getArbitreChef() + "',");
            requete.append("'" + match.getArbitreAdjoint() + "')");

            int idLastInserted = stm.executeUpdate(requete.toString(), Statement.RETURN_GENERATED_KEYS);

            stm.close();
            stm = null;

            LOGGER.debug("Requete SQL : " + requete);

            //            new MatchHTMLDAO().save(match, html);

        }
        catch(SQLException e)
        {
            LOGGER.debug("Requete SQL : " + requete);
            LOGGER.error("SQLException ", e);
        }
    }

    public List<String> getAllID()
    {
        List<String> idsMatch = new ArrayList<String>();

        String requete = "SELECT id_match FROM `match`";

        try
        {
            Statement stm = connection.createStatement();
            ResultSet resultat = stm.executeQuery(requete);

            while(resultat.next())
            {
                idsMatch.add(resultat.getString("id_match"));
            }

            resultat.close();
            resultat = null;
            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            LOGGER.error(requete, e);
        }

        return idsMatch;
    }

    public Match getMatchFromID(String id)
    {
        Match match = new Match();

        String requete =
            "SELECT `id`, `id_match`, `bleu`, `gris`, `noir`, `arbitre_chef`, `arbitre_adjoint` FROM `match` WHERE `id_match` ='"
                + id + "'";

        try
        {
            Statement stm = connection.createStatement();
            ResultSet resultat = stm.executeQuery(requete);

            while(resultat.next())
            {
                match.setIdMatch(resultat.getString("id_match"));
                match.setBleu(new EquipeDAO().getEquipeFromId(resultat.getInt("bleu")));
                match.setGris(new EquipeDAO().getEquipeFromId(resultat.getInt("gris")));
                match.setNoir(new EquipeDAO().getEquipeFromId(resultat.getInt("noir")));
                match.setArbitreChef(resultat.getString("arbitre_chef"));
                match.setArbitreAdjoint(resultat.getString("arbitre_adjoint"));
            }

            resultat.close();
            resultat = null;
            stm.close();
            stm = null;
        }
        catch(SQLException e)
        {
            LOGGER.error(requete, e);
        }

        return match;
    }
}
