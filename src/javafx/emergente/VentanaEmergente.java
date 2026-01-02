package javafx.emergente;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaEmergente {
	
	public static void mostrarVentana(String titulo, String mensaje, int width, int height) {
		
		// primero creamos el stage
		Stage myStage= new Stage();
		myStage.initModality(Modality.APPLICATION_MODAL);
		myStage.setTitle(titulo);
//		myStage.setMinWidth(250);
		myStage.setMinHeight(50);
		
		Label myLabel= new Label();
		myLabel.setText(mensaje);
		
		Button myButton= new Button();
		myButton.setText("Cerrar");
		
		myButton.setOnAction(e->myStage.close());
		
		// creamos el pane
		BorderPane myPane= new BorderPane();
		
		// creamos la escena
		Scene myScene= new Scene(myPane, width, height);
		
		// añadimos objetos al pane
		myPane.setTop(myLabel);
		myPane.setCenter(myButton);
		
		// añadimos al stage la escena
		myStage.setScene(myScene);
		
		// mostramos el stage
		myStage.showAndWait();
		
	}
}
