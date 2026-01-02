package javafx;
	
import emergente.VentanaEmergente;
import emergente.VentanaSiNo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PedidosPizza_ListView extends Application {
	private Stage myStage;
	private TextField txtNombre;
	private TextField txtNumTlf;
	private TextField txtDireccion;
	private RadioButton small, medium, xxl;
	private RadioButton fine, normal;
	private ToggleGroup sizeGroup;
	private ToggleGroup typeGroup;
	private ListView<String> ingredientList;

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
		Label sizeText= new Label("Tamaño Pizza");

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
		
		fine= new RadioButton("Fina");
		normal= new RadioButton("Normal");
		
		fine.setSelected(true);
		
		typeGroup= new ToggleGroup();
		fine.setToggleGroup(typeGroup);
		normal.setToggleGroup(typeGroup);
		
		VBox typeRadio= new VBox(tipoMasa, fine, normal);
		typeRadio.setPadding(new Insets(10,0,0,10));
		
	
		/* --------------------- INGREDIENTS AREA --------------------- */
		Label lblIngredients= new Label("Ingredientes");
		VBox lblVBox= new VBox(lblIngredients);
		lblVBox.setAlignment(Pos.CENTER);
		
		ingredientList= new ListView<>();
		
		String[] ingredientes= {
			"Pepperoni",
			"Queso",
			"Pimiento",
			"Aceitunas",
			"Champiñones",
			"Tomates",
			"Anchoas"
		};
		
		ingredientList.setPrefSize(240, 100);
		ingredientList.getItems().addAll(ingredientes);
		ingredientList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		VBox ingredientsVBox= new VBox(lblVBox, ingredientList);
		ingredientsVBox.setPadding(new Insets(10,0,0,10));
		ingredientsVBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		/* --------------------- HBOX size, type, ingredients --------------------- */
		
		HBox fifth= new HBox(size, typeRadio, ingredientsVBox);
		
		/* --------------------- BUTTON AREA --------------------- */
		Button okButton= new Button("OK");
		Button resetButton= new Button("Resetear");
		HBox buttonArea= new HBox(okButton, resetButton);
		buttonArea.setAlignment(Pos.BOTTOM_RIGHT);
		buttonArea.setPadding(new Insets(0,10,0,0));
		
		/* --------------------- BUTTON ACTION --------------------- */
		okButton.setOnAction(e-> okButton());
		resetButton.setOnAction(e-> resetButton());
		
		
		/* --------------------- CREAMOS VBox PARA ALMACENAR TODOS LOS PANES --------------------- */
		/* --------------------- Y PODER AÑADIR EL VBOX GENERAL AL SCENE --------------------- */
		VBox myVBox= new VBox(5, first, second, third, four, fifth, buttonArea);
		
		Scene myScene= new Scene(myVBox, 410, 280);
		
		primaryStage.setTitle("Pizza Express");
		primaryStage.setMinWidth(430);
		primaryStage.setMinHeight(310);
		primaryStage.setResizable(false);
		
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

	private void resetButton() {
		txtNombre.setText("");
		txtNumTlf.setText("");
		txtDireccion.setText("");
		
		small.setSelected(false);
		medium.setSelected(false);
		xxl.setSelected(false);
		
		fine.setSelected(false);
		normal.setSelected(false);
		
		ingredientList.getSelectionModel().clearSelection();
	}
	
	public String getIngredientes() {
		String ingredients= "\nIngredientes: ";
		
		ObservableList<String> selectedItems= ingredientList.getSelectionModel().getSelectedItems();
		if (selectedItems.isEmpty()) return ingredients= "\nIngredientes: (ninguno)";
		int count=0;

		for (String item: selectedItems) {
			if (count == selectedItems.size()-1) ingredients+= item.toString() + ".";
			else ingredients+= item.toString() + ", ";
			count++;
		}
		
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
