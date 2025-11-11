package interfacesGraficas.interfaces1;

import javax.swing.JFrame;

public class SegundoJFrame {
	public static void main(String[] args) {
		MiJFrame miVentana= new MiJFrame();
	}
}

class MiJFrame extends JFrame {
	public MiJFrame () {
		setSize(500,300);
//		setLocation(300,200);
//		setResizable(false);
		setLocationRelativeTo(null);
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
