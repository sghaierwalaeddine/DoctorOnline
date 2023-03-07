package oo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connexion.ConnexionBD;

public class Patient {
	private static String id;
	private String mdp;
	private static String nom;
	private String prenom;
	private String tel;
	
	public Patient(String id, String mdp, String nom, String prenom,String tel) throws SQLException {
		this.id = id;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.tel=tel;
	}

	public static String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public static String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getTel() {
		return tel;
	}
	
}
