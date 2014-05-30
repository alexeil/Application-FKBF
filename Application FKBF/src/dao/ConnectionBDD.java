package dao;

import generators.CalendarGenerator;

import java.sql.Connection;

import java.sql.DriverManager;

import org.apache.log4j.Logger;

/**
 * Classe permettant de gérer la connexion au sein de la BDD
 */
public class ConnectionBDD {

	private final static Logger LOGGER = Logger.getLogger(ConnectionBDD.class.getName());

	public static String user = "root";// utilisateur de la bdd
	public static String url = "jdbc:mysql://127.0.0.1:";// url de la bdd
	public static String bdd = "/application_fkbf";
	public static String port = "3306";
	public static String driver = "com.mysql.jdbc.Driver";
	public static Connection connection;// connexion a la bdd

	/**
	 * Retourne l'instance de la connexion avec la BDD
	 * 
	 * @return connection
	 */
	public static Connection getInstance() {
		if (connection != null) {
			return connection;
		}
		
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la création d'une nouvelle instance de connection",e);
		}

		try {
			connection = DriverManager.getConnection(url + port + bdd, user, "");
		} catch (Exception e) {
			LOGGER.error("Erreur lors de la connection",e);
		}
		return connection;
	}

}
