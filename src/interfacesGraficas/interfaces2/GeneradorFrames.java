package interfacesGraficas.interfaces2;

import java.awt.*;
import javax.swing.JFrame;

public class GeneradorFrames {
	public static void main(String[] args) {
		GeneradorVentanas v1= new GeneradorVentanas("Mi ventana", 300, 300, 600, 300);
		v1.setImage("src/interfacesGraficas/interfaces2/bag of coins.png");
	}
}


class GeneradorVentanas extends JFrame {
	private Image imagen;
	
	public GeneradorVentanas (String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setImage(String src) {
		Toolkit miSistema= Toolkit.getDefaultToolkit();
		this.imagen= miSistema.getImage(src);
		setIconImage(imagen);
	}
}