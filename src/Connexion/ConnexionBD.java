package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static String url = "jdbc:mysql://localhost:3306/gpatients";
	private static String user = "root";
	private static String passwd = "root";
	private static Connection cn =null;
	
	public  ConnexionBD() {
	try { cn = DriverManager.getConnection(url, user, passwd);
	} catch ( Exception e ) { System.out.println("maconectech");e.printStackTrace(); }
	}
	
	// Récupérer l’instance de la connexion
	public  static Connection getConnection() {
	if (cn == null) { new ConnexionBD();
	System.out.println("connexion reussite !");}
	return cn;
	}
	
	public static void Fermer() {
	if (cn != null) {
	try { cn.close();}
	catch (SQLException e) { e.printStackTrace(); }
	}
	}
	
}