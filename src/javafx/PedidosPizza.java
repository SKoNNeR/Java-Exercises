package javafx;
	
import emergente.VentanaEmergente;
import emergente.VentanaSiNo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PedidosPizza extends Application {
	private Stage myStage;
	private TextField txtNombre;
	private TextField txtNumTlf;
	private TextField txtDireccion;
	private CheckBox pepperoni, queso, pimiento, aceitunas, champinon, tomates, anchoas;
	private RadioButton small, medium, xxl;
	private RadioButton fine, normal;
	private ToggleGroup sizeGroup;
	private ToggleGroup typeGroup;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		myStage= primaryStage;
		
		primaryStage.setOnCloseRequest(e-> {
			e.consume();
			closeApp();
		});
		
		/* --------------------- LABEL AREA --------------------- */
		Label title= new Label("Pide tu pizza personalizada");
		title.setFont(new Font("Arial Black", 20));
		Label name= new Label("Nombre: ");
		Label tlf= new Label("N Teléfono: ");
		Label dir= new Label("Dirección: ");
		
		name.setPadding(new Insets(0, 50, 0, 0));
		tlf.setPadding(new Insets(0, 35, 0, 0));
		dir.setPadding(new Insets(0, 45, 0, 0));
		
		/* --------------------- TEXTFIELD AREA --------------------- */
		txtNombre= new TextField();
		txtNumTlf= new TextField();
		txtDireccion= new TextField();
		
		txtNombre.setPromptText("Introduce el Nombre");
		txtNumTlf.setPromptText("Introduce el Teléfono");
		txtDireccion.setPromptText("Introduce la Dirección");
		
		txtNombre.setPrefColumnCount(25);
		txtNumTlf.setPrefColumnCount(25);
		txtDireccion.setPrefColumnCount(25);
		
		HBox first= new HBox(title);
		first.setAlignment(Pos.CENTER);
		HBox second= new HBox(name, txtNombre);
		HBox third= new HBox(tlf, txtNumTlf);
		HBox four= new HBox(dir, txtDireccion);
		second.setPadding(new Insets(0, 0, 0, 10));
		third.setPadding(new Insets(0, 0, 0, 10));
		four.setPadding(new Insets(0, 0, 0, 10));
		
		
		/* --------------------- SIZE AREA --------------------- */
		Label sizeText= new Label("Pizza Size");

		small= new RadioButton("Small");
		medium= new RadioButton("Medium");
		xxl= new RadioButton("XXL");
		
		medium.setSelected(true);
		
		sizeGroup= new ToggleGroup();
		
		small.setToggleGroup(sizeGroup);
		medium.setToggleGroup(sizeGroup);
		xxl.setToggleGroup(sizeGroup);
		
		VBox size= new VBox(sizeText, small, medium, xxl);
		size.setPadding(new Insets(10,0,0,10));
		
		/* --------------------- BREAD TYPE --------------------- */
		Label tipoMasa= new Label("Masa");
		
		fine= new RadioButton("Fine");
		normal= new RadioButton("Normal");
		
		fine.setSelected(true);
		
		typeGroup= new ToggleGroup();
		fine.setToggleGroup(typeGroup);
		normal.setToggleGroup(typeGroup);
		
		VBox typeRadio= new VBox(tipoMasa, fine, normal);
		typeRadio.setPadding(new Insets(10,0,0,10));
		
	
		/* --------------------- INGREDIENTS AREA --------------------- */
		Label lblIngredients= new Label("Ingredientes");
		lblIngredients.setPadding(new Insets(10,0,0,0));
		
		pepperoni= new CheckBox("Pepperoni");
		queso= new CheckBox("Queso");
		pimiento= new CheckBox("Pimiento");
		VBox firstIngredients= new VBox(pepperoni, queso, pimiento);
		
		aceitunas= new CheckBox("Aceitunas");
		champinon= new CheckBox("Champiñones");
		tomates= new CheckBox("Tomates");
		VBox secondIngredients= new VBox(aceitunas, champinon, tomates);
		
		anchoas= new CheckBox("Anchoas");
		VBox thirdIngredients= new VBox(anchoas);
		
		firstIngredients.setPadding(new Insets(10));
		secondIngredients.setPadding(new Insets(10));
		thirdIngredients.setPadding(new Insets(10));
		
		FlowPane paneIngredientes= new FlowPane(Orientation.VERTICAL, pepperoni, queso, pimiento, aceitunas, champinon, tomates, anchoas);
		paneIngredientes.setPadding(new Insets(10,0,0,10));
		paneIngredientes.setHgap(10);
		paneIngredientes.setVgap(10);
		paneIngredientes.setPrefWrapLength(100);
		
		VBox paneLblPaneIngredientes= new VBox(lblIngredients, paneIngredientes);
		
		/* --------------------- HBOX size, type, ingredients --------------------- */
		
		HBox fifth= new HBox(size, typeRadio, paneLblPaneIngredientes);
		
		/* --------------------- BUTTON AREA --------------------- */
		Button okButton= new Button("OK");
		Button cancelButton= new Button("Cancel");
		HBox buttonArea= new HBox(okButton, cancelButton);
		buttonArea.setAlignment(Pos.BOTTOM_RIGHT);
		buttonArea.setPadding(new Insets(0,10,0,0));
		
		/* --------------------- BUTTON ACTION --------------------- */
		okButton.setOnAction(e-> okButton());
		cancelButton.setOnAction(e-> cancelButton());
		
		VBox myVBox= new VBox(5, first, second, third, four, fifth, buttonArea);
		
		Scene myScene= new Scene(myVBox, 450, 280);
		
		primaryStage.setScene(myScene);
		
		primaryStage.show();
	}
	

	private void okButton() {
		String mensaje= "";
		RadioButton selectedSize= (RadioButton) sizeGroup.getSelectedToggle();
		RadioButton selectedType= (RadioButton) typeGroup.getSelectedToggle();
		if (txtNombre.getText().isEmpty()) mensaje+= "\nIntroduce un nombre.";
		if (!checkTlf()) mensaje+= "\nIntroduce un teléfono valido.";
		if (txtDireccion.getText().isEmpty()) mensaje+= "\nIntroduce una dirección.";
		if (selectedSize == null) mensaje+= "\nSelecciona un tamaño de pizza.";
		if (selectedType == null) mensaje+= "\nSelecciona un tipo de masa.";
		if (mensaje.isEmpty() && selectedSize != null && selectedType != null) {
			VentanaEmergente.mostrarVentana("Pizza Espress", "~~ Cliente: ~~\n\tNombre: " + txtNombre.getText() + "\n\tTeléfono: " + txtNumTlf.getText() + "\n\tEnviar a: " + txtDireccion.getText() + "\nTamaño: " + selectedSize.getText() + "   |   Masa: " + selectedType.getText() + getIngredientes(), 400, 200);
			
		} else {
			VentanaEmergente.mostrarVentana("Faltan Datos.", mensaje, 250, 150);
		}
	}

	private void closeApp() {
		if (VentanaSiNo.mostrarVentanaSiNo("¿Salir?", "¿Cancelar pedido?")) {
			myStage.close();
		}
		
	}

	private void cancelButton() {
		txtNombre.setText("");
		txtNumTlf.setText("");
		txtDireccion.setText("");
		
		small.setSelected(false);
		medium.setSelected(false);
		xxl.setSelected(false);
		
		fine.setSelected(false);
		normal.setSelected(false);
		
		pepperoni.setSelected(false);
		queso.setSelected(false);
		pimiento.setSelected(false);
		aceitunas.setSelected(false);
		champinon.setSelected(false);
		tomates.setSelected(false);
		anchoas.setSelected(false);
	}
	
	public String getIngredientes() {
		String ingredients= "\nIngredientes: ";
			if (pepperoni.isSelected()) ingredients+= pepperoni.getText() + ", ";
			if (queso.isSelected()) ingredients+= queso.getText() + ", ";
			if (pimiento.isSelected()) ingredients+= pimiento.getText() + ", ";
			if (aceitunas.isSelected()) ingredients+= aceitunas.getText() + ", ";
			if (champinon.isSelected()) ingredients+= champinon.getText() + ", ";
			if (tomates.isSelected()) ingredients+= tomates.getText() + ", ";
			if (anchoas.isSelected()) ingredients+= anchoas.getText() + ", ";
		return ingredients;
	}
	
	public boolean checkTlf() {
		String tlfTxt= txtNumTlf.getText();
		return tlfTxt.matches("\\d{9,11}");
	}

	public static void main(String[] args) {
		launch(args);
	}


}
