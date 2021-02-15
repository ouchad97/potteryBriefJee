package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

	String PILOTE = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5050/SbahiaDB";
	//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	static String dbUser = "postgres";
	static String dbPass = "admin";
	static Connection connection = null;

	// Connexion a la base de donnees
	public static Connection getMyConnexion() throws ClassNotFoundException,
			SQLException {
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, dbUser, dbPass);
		
		return connection;
	}

}