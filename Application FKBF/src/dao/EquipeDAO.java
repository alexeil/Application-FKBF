package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import metier.Equipe;

import org.apache.log4j.Logger;

public class EquipeDAO
{

    private final static Logger LOGGER = Logger.getLogger(EquipeDAO.class.getName());

    private Connection connection;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructeur
     */
    public EquipeDAO()
    {
        this.connection = ConnectionBDD.getInstance();
    }

    // public void insertClassement(classement.Classement classement) {
    //
    // Statement stm;
    // try {
    // stm = connection.createStatement();
    //
    // StringBuilder requete = new StringBuilder();
    // StringBuilder subRequete = new StringBuilder();
    //
    // requete.append("INSERT INTO equipe (color, isForfait, p1, p2, p3, p4, p5, p6, p7, prol1, prol2, prol3, prol4, prol5, prol6, prol7, prol_deuxieme, nb_periode, esprit_sportif, points) VALUES (");
    // //NULL, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '',
    // '', '', '', '');
    //
    // requete.append("INSERT INTO classement  (  division , sexe , date ,  rang ,  logo ,  nom_equipe ,  points ,  match_joue , premiere_place ,  deuxieme_place ,  troisieme_place ,  forfait , nb_periode ,  esprit_sportif )");
    // requete.append(" VALUES (");
    // requete.append("'" + classement.getPoule() + "',");
    // requete.append("'" + classement.getSexe() + "',");
    // requete.append("'" + DATE_FORMAT.format(new Date(classement.getDate())) +
    // "',");
    //
    // for (Team team : classement.getTeams()) {
    // subRequete = new StringBuilder();
    //
    // subRequete.append(requete);
    // subRequete.append("'" + team.getRank() + "',");
    // subRequete.append("'" + team.getLogo() + "',");
    // subRequete.append("'" + team.getTeam() + "',");
    // subRequete.append("'" + team.getPoints().replace("-", "0") + "',");
    // subRequete.append("'" + team.getMj().replace("-", "0") + "',");
    // subRequete.append("'" + team.getFirst().replace("-", "0") + "',");
    // subRequete.append("'" + team.getSecond().replace("-", "0") + "',");
    // subRequete.append("'" + team.getThird().replace("-", "0") + "',");
    // subRequete.append("'" + team.getForfeit().replace("-", "0") + "',");
    // subRequete.append("'" + team.getNbPeriodes().replace("-", "0") + "',");
    // subRequete.append("'" + team.getFairPlay().replace("-", "0") + "')");
    //
    // System.out.println(subRequete.toString());
    // stm.executeUpdate(subRequete.toString());
    // }
    // stm.close();
    // stm = null;
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    //
    // }
    //
    // public classement.Classement selectAllClassement(long date, String sexe,
    // String division) {
    //
    // classement.Classement classement = new classement.Classement();
    // List<Team> teams = new ArrayList<Team>();
    //
    // StringBuilder requete = new StringBuilder();
    // requete.append("SELECT * FROM CLASSEMENT");
    // requete.append(" WHERE ");
    // requete.append(" date ='" + DATE_FORMAT.format(new Date(date)) +
    // "'  AND");
    // requete.append(" sexe ='" + sexe + "' AND ");
    // requete.append(" division ='" + division + "'");
    //
    // try {
    // Statement stm = connection.createStatement();
    // ResultSet resultat = stm.executeQuery(requete.toString());
    //
    // while (resultat.next()) {
    //
    // classement.setDate(resultat.getDate("date").getTime());
    // classement.setHomme(resultat.getString("sexe").equals('M') ? true :
    // false);
    // classement.setPoule(resultat.getString("division"));
    //
    // String rank = resultat.getString("rang");
    // String logo = resultat.getString("logo");
    // String sTeam = resultat.getString("nom_equipe");
    // String points = resultat.getString("points");
    // String mj = resultat.getString("match_joue");
    // String first = resultat.getString("premiere_place");
    // String second = resultat.getString("deuxieme_place");
    // String third = resultat.getString("troisieme_place");
    // String forfeit = resultat.getString("forfait");
    // String nbPeriodes = resultat.getString("nb_periode");
    // String fairPlay = resultat.getString("esprit_sportif");
    //
    //
    // Team oTeam = new Team(rank, logo, sTeam, points, mj, first, second,
    // third, forfeit, nbPeriodes, fairPlay);
    // teams.add(oTeam);
    // }
    //
    // classement.setTeams(teams);
    //
    // resultat.close();
    // resultat = null;
    // stm.close();
    // stm = null;
    // } catch (SQLException e) {
    // System.err.println("Error: queryColumns(): " + requete);
    // e.printStackTrace();
    // }
    //
    // return classement;
    // }
    //
    // public List<DivisionListeElement> getAllDivision(){
    //
    // List<DivisionListeElement> DivisionListeElements = new
    // ArrayList<DivisionListeElement>();
    //
    // String requete = "SELECT DISTINCT division, sexe FROM classement";
    //
    // try {
    // Statement stm = connection.createStatement();
    // ResultSet resultat = stm.executeQuery(requete);
    // DivisionListeElement divisionListeElement;
    // while (resultat.next()) {
    // divisionListeElement = new
    // DivisionListeElement(resultat.getString("division"),
    // resultat.getString("sexe"));
    // DivisionListeElements.add(divisionListeElement);
    // }
    //
    // resultat.close();
    // resultat = null;
    // stm.close();
    // stm = null;
    // } catch (SQLException e) {
    // System.err.println("Error: queryColumns(): " + requete);
    // e.printStackTrace();
    // }
    //
    // return DivisionListeElements;
    // }

    public int save(Equipe equipe)
    {
        Statement stm;
        StringBuilder requete = new StringBuilder();
        try
        {
            stm = connection.createStatement();

            requete
                .append("INSERT INTO equipe  ( color,nom_equipe,isForfait,p1,p2,p3,p4,p5,p6,p7,prol1,prol2,prol3,prol4,prol5,prol6,prol7,prol_deuxieme,nb_periode,esprit_sportif,points )");
            requete.append(" VALUES (");
            requete.append("'" + equipe.getColor() + "',");
            requete.append("'" + equipe.getNomEquipe() + "',");
            requete.append("" + equipe.isForfait() + ",");
            requete.append("'" + equipe.getP1() + "',");
            requete.append("'" + equipe.getP2() + "',");
            requete.append("'" + equipe.getP3() + "',");
            requete.append("'" + equipe.getP4() + "',");
            requete.append("'" + equipe.getP5() + "',");
            requete.append("'" + equipe.getP6() + "',");
            requete.append("'" + equipe.getP7() + "',");
            requete.append("'" + equipe.getProl1() + "',");
            requete.append("'" + equipe.getProl2() + "',");
            requete.append("'" + equipe.getProl3() + "',");
            requete.append("'" + equipe.getProl4() + "',");
            requete.append("'" + equipe.getProl5() + "',");
            requete.append("'" + equipe.getProl6() + "',");
            requete.append("'" + equipe.getProl7() + "',");

            requete.append("'" + equipe.getProl_deuxieme() + "',");
            requete.append("'" + equipe.getNb_periode() + "',");
            requete.append("'" + equipe.getEsprit_sportif() + "',");
            requete.append("'" + equipe.getPoints() + "')");

            int idLastInserted = stm.executeUpdate(requete.toString(), Statement.RETURN_GENERATED_KEYS);
            stm.close();
            stm = null;

            LOGGER.debug("Requete SQL : " + requete);
            LOGGER.debug("idLastInserted : " + idLastInserted);
            return idLastInserted;
        }
        catch(SQLException e)
        {
            LOGGER.debug("Requete SQL : " + requete);
            LOGGER.error("Requete SQL : " + requete);
            LOGGER.error("SQLException ", e);
        }
        return 0;
    }
}
