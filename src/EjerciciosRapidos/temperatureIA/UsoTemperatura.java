package EjerciciosRapidos.temperatureIA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UsoTemperatura {
	public static void main(String[] args) {
		MiFrame f1= new MiFrame();
	}
}

class Termostato implements Regulable {
	private int temperaturaActual= 20;
	
	@Override
	public void subirTemperatura() {
		// TODO Auto-generated method stub
		if (temperaturaActual < Regulable.TEMPERATURA_MAXIMA) temperaturaActual++;
		else System.out.println("No puedes subir más de 30ºC. ¿A caso quieres derretirte?");
	}

	@Override
	public void bajarTemperatura() {
		// TODO Auto-generated method stub
		if (temperaturaActual > Regulable.TEMPERATURA_MINIMA) temperaturaActual--;
		else System.out.println("No puedes bajar de 10ºC. Te entiendo, el calor es insoportable.");
	}
	
	public int getTemp() {
		return temperaturaActual;
	}
}

class MiFrame extends JFrame {
	Termostato termostato= new Termostato();
	
	public MiFrame() {
		setTitle("Termostato");
		setBounds(300,300,600,400);
		add(new MiLamina(this.termostato));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


class MiLamina extends JPanel implements ActionListener {
	JButton subirTemp= new JButton("Subir Temperatura");
	JButton bajarTemp= new JButton("Bajar Temperatura");
	
	private Termostato t;
	private JLabel temp;
	
	public MiLamina (Termostato t) {
		this.t= t;
		String aTemp= String.valueOf(t.getTemp());
		temp = new JLabel(aTemp + "ºC");
		setLayout(null);
		setFocusable(true);
		addKeyListener(new KeyController());
		bajarTemp.setBounds(60, 250,200,30);
		subirTemp.setBounds(290, 250,200,30);
		temp.setFont(new Font("SanSerif", Font.BOLD, 90));
		temp.setBounds(200, 50, 200, 200);
		temp.setPreferredSize(new Dimension(200,200));
		
		add(subirTemp);
		add(bajarTemp);
		add(temp);
		
		subirTemp.addActionListener(this);
		bajarTemp.addActionListener(this);
		
		setBackColor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == subirTemp) t.subirTemperatura();
		else if (e.getSource() == bajarTemp) t.bajarTemperatura();
		temp.setText(t.getTemp() + "ºC");
		setBackColor();
	}

	class KeyController extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) t.subirTemperatura();
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) t.bajarTemperatura();
			temp.setText(t.getTemp() + "ºC");
			setBackColor();
		}
	}
	
	public void setBackColor() {
		if (t.getTemp() > 25) setBackground(new Color(219, 79, 79));
		else if (t.getTemp() < 15) setBackground(new Color(123, 184, 219));
		else setBackground(new Color(222, 215, 215));
	}
}
