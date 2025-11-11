package interfacesGraficas.interfaces3;


import java.awt.*;
import javax.swing.*;

public class VentanasYLaminas {
	public static void main(String[] args) {
		GeneradorVentanas v1= new GeneradorVentanas("Escritura en JFrame", 400, 200, 600, 450);
		v1.setIcon("src/interfacesGraficas/interfaces2/bag of coins.png");
		
	}
}

class GeneradorVentanas extends JFrame {
	private Image imagen;
	
	public GeneradorVentanas (String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);
		setVisible(true);
		// SI VAMOS A MODIFICAR NUESTRA LÁMINA MÁS TARDE PODEMOS
		// INSTANCIARLA ANTES, PrimerPanel miLamina= new PrimerPanel();
		// Y DESPUÉS add(miLamina);
		add(new PrimerPanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setIcon(String src) {
		Toolkit mySistem= Toolkit.getDefaultToolkit();
		Image imagen= mySistem.getImage(src);
		setIconImage(imagen);
	}
}

class PrimerPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		// PODEMOS INSTANCIAR LA FUENTE O CREARLA DIRECTAMENTE
		g.setFont(new Font("Verdana", Font.ITALIC, 20));
		g.drawString("Mi primer panel", 20, 20);
		
	}
}