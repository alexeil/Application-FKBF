package main.java.dao;

/**
 * Classe FactoryDAO Gere l'ensemble des DAO du projet
 */
public class FactoryDAO
{

    private static ClassementDAO classementDAO = null;//
    private static ClassementEquipeDAO classementHtmlDAO = null;
    private static MatchDAO matchDAO = null;

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
    public static ClassementEquipeDAO getClassementHtmlDAO()
    {
        if(classementHtmlDAO == null)
        {
            classementHtmlDAO = new ClassementEquipeDAO();
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
}
