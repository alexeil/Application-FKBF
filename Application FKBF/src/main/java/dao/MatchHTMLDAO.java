package main.java.dao;

import main.java.metier.Match;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.sql.Connection;
import java.text.SimpleDateFormat;

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

    public Match findByIdMatch(String idMatch)
    {
        //        Query query = session.createSQLQuery(
        //            "SELECT * from MatchHtml m where m.match.idMatch= :idMatch")
        //            .addEntity(MatchHtml.class)
        //            .setParameter("idMatch", idMatch);
        //
        //        LOGGER.debug(query.toString());
        //        LOGGER.debug("idMatch : " + idMatch);
        //        return (MatchHtml) query.uniqueResult();
        Query query = session.createSQLQuery(
            "SELECT * from match m where m.idMatch= :idMatch")
            .addEntity(Match.class)
            .setParameter("idMatch", idMatch);

        LOGGER.debug(query.toString());
        LOGGER.debug("idMatch : " + idMatch);
        return (Match) query.uniqueResult();

        //        Query query = session.createSQLQuery(
        //            "SELECT * from MatchHtml m where id_match= :idMatch")
        //            .addEntity(MatchHtml.class)
        //            .setParameter("idMatch", 1);
        //
        //        LOGGER.debug(query.toString());
        //        return (MatchHtml) query.uniqueResult();
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
