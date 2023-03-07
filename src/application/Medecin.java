package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Medecin extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("MedecinInter.fxml"));
			 Parent root =loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Page d'accueil - Interface Médecin");
			primaryStage.setResizable(false);// non redimensionnable
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}