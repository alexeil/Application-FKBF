package main.java.hibernate;

/**
 * Created by thierry on 24/06/2014.
 */
public class main
{
    public static void main(String[] args)
    {
      /*  System.out.println("Hibernate one to one (XML mapping)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        //        Equipe equipe2Save = new Equipe();
        //        equipe2Save.setColor("pink");
        //        equipe2Save.setNomEquipe("test");
        //        equipe2Save.setForfait(false);
        //        equipe2Save.setP1(3);
        //        equipe2Save.setP2(3);
        //        equipe2Save.setP3(3);
        //        equipe2Save.setP4(3);
        //        equipe2Save.setP5(3);
        //        equipe2Save.setP6(3);
        //        equipe2Save.setP7(3);
        //        equipe2Save.setProl1(4);
        //        equipe2Save.setProl2(4);
        //        equipe2Save.setProl3(4);
        //        equipe2Save.setProl4(4);
        //        equipe2Save.setProl5(4);
        //        equipe2Save.setProl6(4);
        //        equipe2Save.setProl7(4);
        //        equipe2Save.setProlDeuxieme(1);
        //        equipe2Save.setNbPeriode(3);
        //        equipe2Save.setEspritSportif(4);
        //        equipe2Save.setPoints(18);
        //
        //        Match match = new Match();
        //
        //        equipe2Save.setMatch(match);
        //        ////
        //        //
        //        //
        //        //        matchHtml.setMatch(match);
        //        //        //        matchHtml.setIdMatch(15);
        //
        //        //
        //
        //        MatchHtml matchHtml = new MatchHtml();
        //        matchHtml.setHtml("TEST");
        //        matchHtml.setMatch(match);
        //
        //        match.setMatchHtml(matchHtml);
        //        match.setBleu(equipe2Save);
        //        match.setGris(equipe2Save);
        //        match.setNoir(equipe2Save);

        MatchHtml matchHtml = new MatchHtml();
        Match match = new Match();
        Equipe equipeB = new Equipe();
        Equipe equipeG = new Equipe();
        Equipe equipeN = new Equipe();

        matchHtml.setMatch(match);
        match.setBleu(equipeB);
        match.setGris(equipeG);
        match.setNoir(equipeN);

        equipeB.setMatch(match);
        equipeG.setMatch(match);
        equipeN.setMatch(match);

        match.setMatchHtml(matchHtml);

        //        matchHtml.setHtml("TEST");

        session.save(matchHtml);

        //        Classement classement = new Classement();
        //        ClassementHtml classementHtml = new ClassementHtml();
        //
        //        classement.setClassementHtml(classementHtml);
        //        classementHtml.setClassement(classement);
        //
        //        session.save(classementHtml);

        session.getTransaction().commit();

        System.out.println("Done");*/
    }
}
