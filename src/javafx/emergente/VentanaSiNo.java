package javafx.emergente;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaSiNo {
	private static Stage myStage;
	private static boolean botonSiPulsado;
	
	public static boolean mostrarVentanaSiNo(String titulo, String mensaje) {
		botonSiPulsado= false;
		
		// creamos el stage
		myStage= new Stage();
		myStage.initModality(Modality.APPLICATION_MODAL);
		myStage.setTitle(titulo);
		myStage.setMinWidth(200);
		myStage.setMinHeight(150);
		
		Label myLabel= new Label();
		myLabel.setText(mensaje);
		
		Button buttonSi= new Button();
		buttonSi.setText("Si");
		buttonSi.setOnAction(e-> clickedOnSi());
		
		Button buttonNo= new Button();
		buttonNo.setText("No");
		buttonNo.setOnAction(e-> clickedOnNo());
		
		// creamos el pane HBox
		HBox myHBox= new HBox(20);
		// llenamos el HBox
		myHBox.getChildren().addAll(buttonSi, buttonNo);
		myHBox.setAlignment(Pos.CENTER);
		
		// creamos el VBox
		VBox myVBox= new VBox(20);
		myVBox.getChildren().addAll(myLabel, myHBox);
		myVBox.setAlignment(Pos.CENTER);
		
		// creamos la Scene
		Scene myScene= new Scene(myVBox, 250, 50);
		
		// añadimos la Scene al Stage
		myStage.setScene(myScene);
		myStage.showAndWait();
		
		return botonSiPulsado;
		
	}

	private static void clickedOnSi() {
		// TODO Auto-generated method stub
		myStage.close();
		botonSiPulsado= true;
	}

	private static void clickedOnNo() {
		// TODO Auto-generated method stub
		myStage.close();
		botonSiPulsado= false;
	}
	
	

}
