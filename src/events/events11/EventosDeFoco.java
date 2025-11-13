package events.events11;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventosDeFoco {
	public static void main (String[] args) {
		MiFrame f1= new MiFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MiFrame extends JFrame {
	public MiFrame () {
		setBounds(300, 300, 600, 400);
		add(new MiLamina());
		setVisible(true);
	}
}

class MiLamina extends JPanel {
	private JTextField campoTexto1, campoTexto2, campoTexto3;
	private JLabel label1, label2, label3;
	
	public MiLamina() {		
		setLayout(null);
		label1 = new JLabel("Usuario:");
		label2 = new JLabel("Password:");
		label3 = new JLabel("Email:");
		
		label1.setBounds(60,10, 150, 20);
		label2.setBounds(50,50, 150, 20);
		label3.setBounds(75, 90, 150, 20);
		
		add (label1);
		add (label2);
		add (label3);
		
		campoTexto1= new JTextField();
		campoTexto2= new JTextField();
		campoTexto3= new JTextField();
		
		campoTexto1.setBounds(120, 10, 150, 20);
		campoTexto2.setBounds(120, 50, 150, 20);
		campoTexto3.setBounds(120, 90, 150, 20);
		
		add(campoTexto1);
		add(campoTexto2);
		add(campoTexto3);
		
		FocusCheck foco= new FocusCheck();
		campoTexto1.addFocusListener(foco);
		campoTexto2.addFocusListener(foco);
		campoTexto3.addFocusListener(foco);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	public void checkPass(JTextField campo) {
		String pass= campoTexto2.getText();
		if (pass.length()<5) {
			System.out.println("Contraseña muy débil.");
		} else {
			System.out.println("Contraseña válida.");
		}
	}
	public void checkEmail(JTextField campo) {
		String email= campoTexto3.getText();
		int arroba=0;
		boolean punto= false;
		for (int i=0; i<email.length(); i++) {
			if (email.charAt(i) == '@') arroba++;
			if (email.charAt(i) == '.') punto= true;
		}
		if (arroba == 1 && punto == true) System.out.println("Email Correcto");
		else System.out.println("Email Incorrecto");
	}
	
	private class FocusCheck implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == campoTexto1) System.out.println("El campo 1 ganó foco");
			else if (e.getSource() == campoTexto2) System.out.println("El campo 2 ganó foco");
		}
		
		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == campoTexto1) System.out.println("Campo 1: Pierde Foco");
			else if (e.getSource() == campoTexto2) checkPass(campoTexto2);
			else if (e.getSource() == campoTexto3) checkEmail(campoTexto3);
		}	
	}
}
