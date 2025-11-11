package interfacesGraficas.interfaces9;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManejoImagenes {
	public static void main(String[] args) {
		MiFrame frame1= new MiFrame("Manejo de imágen", 300, 300, 800, 600);
		frame1.setIcon("src/interfacesGraficas/bag of coins.png");
	}
}

class MiFrame extends JFrame {
	public MiFrame (String title, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(title);
		setBounds(xLoc, yLoc, xSize, ySize);
		add(new MiLamina());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setIcon(String src) {
		Toolkit mySystem= Toolkit.getDefaultToolkit();
		Image imagen= mySystem.getImage(src);
		setIconImage(imagen);
	}
}

class MiLamina extends JPanel {
	private Image imagen;
	private Image glenn;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		// EMPEZAMOS MANEJO DE IMÁGENES
		File miImagen= new File("src/interfacesGraficas/cat.jpeg");
		File glen= new File("src/interfacesGraficas/Glenn_Quagmire.png");
		
		try {
			imagen= ImageIO.read(miImagen);
			glenn= ImageIO.read(glen);
		} catch (IOException e) {
			System.err.println("ERROR: Imágen no encontrada.");
		}
		
		int xImage= glenn.getWidth(this);
		int yImage= glenn.getHeight(this);
		
		g.drawImage(glenn, 0, 0, null);
		
		for (int i=0; i<800; i++) {
			for (int j=0; j<600; j++) {
				
				g.copyArea(0, 0, xImage, yImage, xImage*i,yImage*j);
			
			}
		}
		
		
//		g.drawImage(imagen, 10, 10, null);
//		g.copyArea(10, 10, 300, 300, 0, 200);
	}
	
}