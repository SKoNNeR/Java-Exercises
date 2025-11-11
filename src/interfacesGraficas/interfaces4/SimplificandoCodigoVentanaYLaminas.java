package interfacesGraficas.interfaces4;

import java.awt.*;
import javax.swing.*;

public class SimplificandoCodigoVentanaYLaminas {
	public static void main(String[] args) {
		MiVentana v1= new MiVentana("Mi ventana", 300, 300, 600, 500);
		
	}
}


/*
 * PODEMOS INSTANCIAR UN OBJETO DENTRO DE UN PARÁMETRO SIEMPRE Y CUANDO 
 * NO NECESITEMOS AÑADIR PROPIEDADES DENTRO DE LA CLASE, POR EJEMPLO
 * NO PODREMOS AÑADIR VARIABLES DENTRO DE LA CLASE DE JPanel CUANDO LA INSTANCIAMOS
 * DENTRO DEL PARÁMETRO.
 */

class MiVentana extends JFrame {
	public MiVentana(String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);
		setVisible(true);
		add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setFont(new Font("Verdana", Font.BOLD, 20));
				g.setColor(Color.BLUE);
				g.drawLine(0, 0, 500, 500);
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}