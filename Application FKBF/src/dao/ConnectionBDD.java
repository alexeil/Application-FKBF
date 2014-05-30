package dao;

import java.sql.Connection;

import java.sql.DriverManager;

/**
 * Classe permettant de gérer la connexion au sein de la BDD
 */
public class ConnectionBDD {

	public static String user = "root";// utilisateur de la bdd
	public static String url = "jdbc:mysql://127.0.0.1:";// url de la bdd
	public static String bdd = "/application_fkbf";
	public static String port = "3306";
	public static String driver = "com.mysql.jdbc.Driver";
	public static Connection connection;// connexion a la bdd

	/**
	 * Retourne l'instance de la connexion avec la BDD
	 * @return connection
	 */
	public static Connection getInstance() {
		if (connection != null)
			return connection;
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager
					.getConnection(url + port + bdd, user, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
