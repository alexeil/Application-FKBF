package src.main.java.dao;

import org.apache.log4j.Logger;

import src.main.java.metier.Match;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MatchHTMLDAO
{
    private final static Logger LOGGER = Logger.getLogger(MatchHTMLDAO.class.getName());

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private Connection connection;

    /**
     * Constructeur
     */
    public MatchHTMLDAO()
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

            requete.append("INSERT INTO match_Html  ( identifiant_match , html )");
            requete.append(" VALUES (");
            requete.append("'" + match.getIdMatch() + "',");
            requete.append("'" + html.toString().replace("'", "\\'") + "' )");

            stm.executeUpdate(requete.toString());
            stm.close();
            stm = null;

            LOGGER.debug("Requete SQL : " + requete);
        }
        catch(SQLException e)
        {
            LOGGER.error("Requete SQL : " + requete);
            LOGGER.error("SQLException ", e);
        }
    }
}
