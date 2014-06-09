package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Equipe;
import metier.Match;

import org.apache.log4j.Logger;

public class MatchDAO
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

            new MatchHTMLDAO().save(match, html);

        }
        catch(SQLException e)
        {
            LOGGER.debug("Requete SQL : " + requete);
            LOGGER.error("SQLException ", e);
        }

    }
}
