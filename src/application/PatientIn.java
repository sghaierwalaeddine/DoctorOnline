package application;
import ihm.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Connexion.ConnexionBD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import oo.Patient;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PatientIn extends Application  implements EventHandler<ActionEvent> {
	Button btn1 = new Button("Se connecter");
	Hyperlink creer = new Hyperlink("Si vous ne disposez pas d'un compte cliquer ici");
	TextField userTextField = new TextField();
	PasswordField pwBox = new PasswordField();
	
	Stage s;
	
	public void start(Stage primaryStage) {
		try {
			GridPane grid= new GridPane();
			
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
						
			Image img=new Image("logo.png",300,220,false,true);
			ImageView imgv=new ImageView(img);
			grid.add(imgv, 0, 0,2,1);
			
			Text bien = new Text("Bienvenue cher patient !");
			bien.setFill(Color.MINTCREAM);
			bien.setFont(Font.font("Serif Bold", FontWeight.NORMAL, 22));
			grid.add(bien, 0, 1, 2, 1);
			
			Text scenetitle = new Text("Veuillez vous identifier");
			scenetitle.setFill(Color.MINTCREAM);
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
			grid.add(scenetitle, 0, 2, 2, 1);

			Label userName = new Label("Nom d'utilisateur");
			userName.setTextFill(Color.MINTCREAM);
			grid.add(userName, 0, 3);

			grid.add(userTextField, 1, 3);
			
			Label pw = new Label("Mot de passe");
			pw.setTextFill(Color.GHOSTWHITE);
			grid.add(pw, 0, 4);

			grid.add(pwBox, 1, 4);
			
			/////////////////blaset button
			btn1.setStyle("-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%); -fx-background-radius: 30; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn1);
			grid.add(hbBtn, 1, 5);
			
			creer.setFont(Font.font("Serif Bold", FontWeight.NORMAL, 14));
			grid.add(creer, 0, 6, 2, 1);
			
			btn1.addEventHandler(ActionEvent.ACTION , this);			
			creer.addEventHandler(ActionEvent.ACTION , this);	
			
			//css bckground color
			grid.setStyle("-fx-background-image: url('test1.png');-fx-background-repeat: no-repeat; -fx-background-position: center center;");
			
			Scene scene = new Scene(grid,750,690);
			//Scene scene = new Scene(grid,1366,706);
           //scene.setStyle();
			//grid.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);// non redimensionnable
			primaryStage.setTitle("Page d'accueil - Gestion de patient");
			primaryStage.setScene(scene);
			//primaryStage.setFullScreen(true);
			primaryStage.show();
			s=primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void handle(ActionEvent e) {
				Object source = e.getSource();
				if (source == btn1) {
					String iden=userTextField.getText();
					String mot=pwBox.getText();
							if (compteExiste(iden,mot)) {//lancer 2eme interface patient 
								try {
									deuxInterPat deuxInter = new deuxInterPat();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
								s.hide();
							}
							else {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Verification");
								alert.setHeaderText("Identifiant ou mot de passe incorrecte!\nPriere de vérifier les informations saisies");
								alert.setContentText("Si ne vous disposez pas de compter, vous pouvez créer un compte");
								alert.showAndWait();
							}
					}
				else if (source == creer) {//lancer interface creer
					signUpInter sing = new signUpInter();	
				}
			}
	
	public boolean compteExiste(String info1,String info2) {
		boolean r = false;
		try {
			Connection cn=ConnexionBD.getConnection();
			String rq="select * from patients where id like '"+info1+"' and mdp like '"+info2+"';";
			Statement st=cn.createStatement();
		    ResultSet rs = st.executeQuery(rq);
			if (rs.next()) {
								Patient p=new Patient(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
								r=true;}
			else {r=false;}
		}catch(Exception e) {
			System.out.println(e.getMessage());
										}	
		return r;
		}
}