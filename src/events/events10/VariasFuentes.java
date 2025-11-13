package events.events10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariasFuentes {
	public static void main(String[] args) {
		MiFrame f1= new MiFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MiFrame extends JFrame {
	public MiFrame() {
		setBounds(600, 300, 500, 350);
		add(new LaminaFuentes());
		setVisible(true);
	}
	private class LaminaFuentes extends JPanel implements ActionListener{
		JButton b1= new JButton("Rojo");
		JButton b2= new JButton("Verde");
		JButton b3= new JButton("Azúl");
		
		public LaminaFuentes() {
			add(b1);
			add(b2);
			add(b3);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			
		b1.addKeyListener(new EventoTeclado());
		b2.addKeyListener(new EventoTeclado());
		b3.addKeyListener(new EventoTeclado());
		
		setFocusable(true);
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object botonPulsado= e.getSource();
			if (botonPulsado == b1) setBackground(Color.RED);
			else if (botonPulsado == b2) setBackground(Color.GREEN);
			else if (botonPulsado == b3) setBackground(Color.BLUE);
		}
		
		private class EventoTeclado extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_R) setBackground(Color.RED);
				else if (e.getKeyCode() == KeyEvent.VK_G) setBackground(Color.GREEN);
				else if (e.getKeyCode() == KeyEvent.VK_B) setBackground(Color.BLUE);
			}
		}
	}
}


