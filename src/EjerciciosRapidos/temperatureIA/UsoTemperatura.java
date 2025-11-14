package EjerciciosRapidos.temperatureIA;

import java.awt.Dimension;
import java.awt.Font;

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
	int temperaturaActual= 20;
	
	@Override
	public void subirTemperatura() {
		// TODO Auto-generated method stub
		if (temperaturaActual < Regulable.TEMPERATURA_MAXIMA) temperaturaActual++;
	}

	@Override
	public void bajarTemperatura() {
		// TODO Auto-generated method stub
		if (temperaturaActual > Regulable.TEMPERATURA_MINIMA) temperaturaActual--;
	}
	
	public int getTemp() {
		return temperaturaActual;
	}
	
}

class MiFrame extends JFrame {
	public MiFrame() {
		setTitle("Termostato");
		setBounds(300,300,600,400);
		add(new MiLamina());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class MiLamina extends JPanel {
	JButton subirTemp= new JButton("Subir Temperatura");
	JButton bajarTemp= new JButton("Bajar Temperatura");
	
	Termostato t= new Termostato();
	String aTemp= String.valueOf(t.getTemp());
	JLabel temp= new JLabel(aTemp + "ºC");
	
	public MiLamina () {
		setLayout(null);
		subirTemp.setBounds(60, 250,200,30);
		bajarTemp.setBounds(290, 250,200,30);
		temp.setFont(new Font("SanSerif", Font.BOLD, 90));
		temp.setBounds(200, 50, 200, 200);
		temp.setPreferredSize(new Dimension(200,200));
		
		add(subirTemp);
		add(bajarTemp);
		add(temp);
		
	}
	
}
