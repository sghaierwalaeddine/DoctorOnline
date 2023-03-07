module Aprojet {
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ihm to javafx.fxml;
	opens oo to javafx.fxml;
	opens Connexion to javafx.fxml;
	//opens oo.RendezVous to javafx.fxml;
	
	exports oo;
	exports application;
	exports ihm;
	exports Connexion;
	}
