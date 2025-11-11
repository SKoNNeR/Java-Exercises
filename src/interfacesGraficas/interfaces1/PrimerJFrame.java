package interfacesGraficas.interfaces1;

import java.awt.Dimension;
import javax.management.ObjectName;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PrimerJFrame {
	public static void main(String[] args) {
		
		JFrame miVentana= new JFrame();
//		miVentana.setSize(500,200);
		miVentana.setBounds(600,300,600,350);
		miVentana.setVisible(true);
		
		// podemos usar el 3 que es el valor que devuelve
		// la constante de WindowConstants.EXIT_ON_CLOSE
//		miVentana.setDefaultCloseOperation(3);
		
//		podemos usar la constante a la que pertenece:
//		miVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
//		podemos usar también la clase
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MiPrimeraVentana {
	
}
