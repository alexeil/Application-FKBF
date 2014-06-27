package main.java.dao;

import main.java.metier.Match;
import main.java.metier.MatchHtml;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MatchHTMLDAO
    extends CommonDAO
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

    public boolean isIdMatchAlreadyExists(String idMatch)
    {
       return (null != this.findByIdMatch(idMatch));
    }

    public MatchHtml findByIdMatch(String idMatch)
    {
         Query query = session.createQuery(
                "SELECT m from MatchHtml m where m.match.idMatch= :idMatch")
            .setParameter("idMatch", idMatch);

        LOGGER.debug(query.toString());
        LOGGER.debug("idMatch : " + idMatch);
        return (MatchHtml) query.uniqueResult();
    }
    //    public void save(Match match, StringBuilder html)
    //    {
    //        Statement stm;
    //        StringBuilder requete = new StringBuilder();
    //        try
    //        {
    //            stm = connection.createStatement();
    //
    //            requete.append("INSERT INTO match_Html  ( identifiant_match , html )");
    //            requete.append(" VALUES (");
    //            requete.append("'" + match.getIdMatch() + "',");
    //            requete.append("'" + html.toString().replace("'", "\\'") + "' )");
    //
    //            stm.executeUpdate(requete.toString());
    //            stm.close();
    //            stm = null;
    //
    //            LOGGER.debug("Requete SQL : " + requete);
    //        }
    //        catch(SQLException e)
    //        {
    //            LOGGER.error("Requete SQL : " + requete);
    //            LOGGER.error("SQLException ", e);
    //        }
    //    }
}
