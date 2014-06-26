package main.java.dao;

/**
 * Classe FactoryDAO Gere l'ensemble des DAO du projet
 */
public class FactoryDAO
{

    private static ClassementDAO classementDAO = null;//
    private static ClassementHtmlDAO classementHtmlDAO = null;
    private static MatchDAO matchDAO = null;
    private static MatchHTMLDAO matchHtmlDAO = null;

    /**
     * Retourne l'objet ClassementDAO.
     *
     * @return classementDAO
     */
    public static ClassementDAO getClassementDAO()
    {
        if(classementDAO == null)
        {
            classementDAO = new ClassementDAO();
        }
        return classementDAO;
    }

    /**
     * Retourne l'objet ClassementHtmlDAO.
     *
     * @return classementHtmlDAO
     */
    public static ClassementHtmlDAO getClassementHtmlDAO()
    {
        if(classementHtmlDAO == null)
        {
            classementHtmlDAO = new ClassementHtmlDAO();
        }
        return classementHtmlDAO;
    }

    public static MatchDAO getMatchDAO()
    {
        if(matchDAO == null)
        {
            matchDAO = new MatchDAO();
        }
        return matchDAO;
    }

    public static MatchHTMLDAO getMatchHtmlDAO()
    {
        if(matchHtmlDAO == null)
        {
            matchHtmlDAO = new MatchHTMLDAO();
        }
        return matchHtmlDAO;
    }
}
