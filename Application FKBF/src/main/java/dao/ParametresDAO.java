package main.java.dao;

import main.java.metier.Match;
import main.java.metier.Parametres;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParametresDAO
    extends CommonDAO
{
    private final static Logger LOGGER = Logger.getLogger(ParametresDAO.class.getName());

    public List<String> findAllDivisions()
    {
        Query query = session.createQuery(
                "SELECT p from Parametres p where p.libelle= :libelle")
                .setParameter("libelle", "divisions");

        String res = ((Parametres) query.uniqueResult()).getValue();
        return Arrays.asList(res.split(","));
    }
}
