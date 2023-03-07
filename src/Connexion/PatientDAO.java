package Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import oo.Patient;

public class PatientDAO {
	public static void singUp(Patient p) {
		try {		
			Connection cn=ConnexionBD.getConnection();
			String rq="insert into patients (`id`, `mdp`, `nom`, `prenom`, `tel`) VALUES ('"+Patient.getId()+"','"+p.getMdp()+"','"+Patient.getNom()+"','"+p.getPrenom()+"','"+p.getTel()+"');";
	        PreparedStatement PreparedStmt = cn.prepareStatement(rq);
	        PreparedStmt.executeUpdate(rq);
		}catch (SQLException e) {
            System.out.println("Ajout impossible à effectuer.\nErreur :" + e);
        }
	}
}
