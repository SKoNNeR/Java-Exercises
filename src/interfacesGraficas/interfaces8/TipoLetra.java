package interfacesGraficas.interfaces8;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TipoLetra {
	public static void main(String[] args) {
		MiMarco m1= new MiMarco("Fuentes", 300, 300, 800, 600);
	}
}

class MiMarco extends JFrame {
	public MiMarco (String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);
		add(new MiLamina());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class MiLamina extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setFont(new Font("Arial", Font.BOLD, 26));
		g2.setPaint(Color.BLUE);
		g2.drawString("Hola qué tal?", 20, 20);
	}
}
