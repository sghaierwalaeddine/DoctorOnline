package application;
import javafx.event.ActionEvent;

import java.io.IOException;
import ihm.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Medecinc {

    @FXML
    private Button b;

    @FXML
    private PasswordField pw;

    @FXML
    void handle(ActionEvent event) throws IOException {
    	if(event.getSource()==b) {
    		if(pw.getText().equals("123")) {
    			System.out.println("médecin connecté");
    			deuxInterMed d=new deuxInterMed();
    		    Node  source = (Node)  event.getSource(); 
    		    Stage stage  = (Stage) source.getScene().getWindow();
    		    stage.close();
    			
    		}
    		else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Verification de données saisie");
				alert.setContentText("Mot de passe incorrecte!");
				alert.showAndWait();
    			}
    	}
    }

}
