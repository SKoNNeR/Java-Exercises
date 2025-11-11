package interfacesGraficas.interfaces6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DibujarEnLaminas {
	public static void main(String[] args) {
		MiFrame frame1= new MiFrame("Mi sexto interfaz", 300, 300, 800, 450);
		frame1.setImage("src/interfacesGraficas/interfaces2/bag of coins.png");
	}
}

class MiFrame extends JFrame {
	private Image imagen;
	
	public MiFrame(String title, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(title);
		setBounds(xLoc, yLoc, xSize, ySize);
//		add(new MiLamina());
		add(new MiLaminaDibujos());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setImage(String src) {
		Toolkit miSistema= Toolkit.getDefaultToolkit();
		Image imagen= miSistema.getImage(src);
		setIconImage(imagen);
	}
}

class MiLamina extends JPanel {
	public MiLamina() {
		setBackground(Color.GRAY);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.setColor(Color.BLUE);
		g.drawString("Es mi 6 interfaz gráfico", 20, 20);
	}
}

class MiLaminaDibujos extends JPanel {
	public MiLaminaDibujos() {
		setBackground(Color.cyan);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		int a= new Random().nextInt(1_000_000);
//		int b= new Random().nextInt(1_000_000);
//		int c= new Random().nextInt(1_000_000);
//		int d= new Random().nextInt(1_000_000);
		g.drawRect(20, 20, 125, 75);
		g.fill3DRect(20, 120, 125, 75, getFocusTraversalKeysEnabled());
		g.drawLine(20, 20, 145, 75);
	}
}