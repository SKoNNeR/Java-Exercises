package interfacesGraficas.interfaces5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelConParametros {

	public static void main(String[] args) {
		
		MiVentana v1= new MiVentana("Mi Ventana", 300, 300, 600, 450);
		
	}
}

class MiVentana extends JFrame {
	public MiVentana (String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);
		add(new MiLamina());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class MiLamina extends JPanel {
	
	public MiLamina() {
		setBackground(Color.RED);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Verdada", Font.BOLD, 20));
		g.setColor(Color.BLUE);
		g.drawString("Vuelvo a construir una ventana y con su lámina con texto", 20, 20);
	}
}