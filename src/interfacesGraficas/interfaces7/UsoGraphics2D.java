package interfacesGraficas.interfaces7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoGraphics2D {
	public static void main(String[] args) {
		MiFrame v1= new MiFrame("Ventana JFrame", 300, 300, 600, 400);
		v1.setImage("src/interfacesGraficas/interfaces2/bag of coins.png");
	}
}

class MiFrame extends JFrame {
	public MiFrame (String titulo, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(titulo);
		setBounds(xLoc, yLoc, xSize, ySize);
		add(new MiLamina());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setImage(String src) {
		Toolkit miSistema= Toolkit.getDefaultToolkit();
		Image miImagen= miSistema.getImage(src);
		setIconImage(miImagen);
	}
}


class MiLamina extends JPanel {
//	public MiLamina () {
////		setBackground(Color.BLUE);
//		setForeground(Color.RED);
//	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		Rectangle2D rectangulo= new Rectangle2D.Double(20, 20, 300, 300);
		
		float miDash[]= {10.0f};
//		g2.setColor(new Color(120,120,255, 50));
//		g2.fill(rectangulo);
//		g2.setColor(new Color(125,255,255, 120));
		g2.setPaint(Color.RED);
		g2.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, miDash, 0));
		g2.draw(rectangulo);
	}
}
