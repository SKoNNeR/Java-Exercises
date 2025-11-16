package componentesSwing.exercises01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EJ1ComponentesSwing {
	public static void main(String[] args) {
		MyFrame frame1= new MyFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {		
		setTitle("Comprobador Email");
		setBounds(300,300, 500, 250);
		add(new MyLayer());
		setVisible(true);
		
	}
}

class MyLayer extends JPanel {
	JTextField text;
	JButton button;
	JLabel warning;
	public MyLayer() {
		setLayout(new BorderLayout());
		text= new JTextField();
		button= new JButton("Comprobar");
		warning= new JLabel("");
		JLabel textBox= new JLabel("Introduce un correo");
		textBox.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel panelNorte= new JPanel();
		panelNorte.setLayout(new GridLayout(2,1));
		panelNorte.add(textBox);
		panelNorte.add(text);
		
//		add(textBox, BorderLayout.NORTH);
//		add(text, BorderLayout.NORTH);
		add(panelNorte, BorderLayout.NORTH);
		
		add(button, BorderLayout.CENTER);
		add(warning, BorderLayout.SOUTH);
		button.addActionListener(new EventoBoton());
	}
	
	public void checkEmail() {
		int arroba=0;
		boolean punto= false;
		if (!text.getText().isEmpty()) {
			for (int i=0; i < text.getText().length(); i++) {				
				if (text.getText().charAt(i) =='@') arroba++;
				if (text.getText().charAt(i) == '.') punto= true;
			}
		}
		if (arroba == 1 && punto== true) warning.setText("Email Correcto");
		else warning.setText("Email Incorrecto");
	}
	
	private class EventoBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checkEmail();
		}
		
	}
}
