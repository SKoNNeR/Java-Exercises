package calculadoraEnero2026;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculadora2026 {
	public static void main(String[] args) {
		CalcuFrame calculadora= new CalcuFrame();
		
	}
}

class CalcuFrame extends JFrame {
	public CalcuFrame() {
		setTitle("Calculadora");
		setBounds(800, 500, 400, 500);
		add(new CalcuLayer());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class CalcuLayer extends JPanel {
	private JLabel display;
	private JPanel panelBotones;
	private EventoBoton listener= new EventoBoton();
	
	public CalcuLayer() {
		setLayout(new BorderLayout());
		
		display= new JLabel("0");
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setFont(new Font("Arial Black", Font.BOLD, 30));
		display.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		panelBotones= new JPanel();
		panelBotones.setLayout(new GridLayout(5,4));
		

		addBotones("CE");
		addBotones("C");
		addBotones("DEL");
		addBotones("/");
		addBotones("7");
		addBotones("8");
		addBotones("9");
		addBotones("*");
		addBotones("4");
		addBotones("5");
		addBotones("6");
		addBotones("-");
		addBotones("1");
		addBotones("2");
		addBotones("3");
		addBotones("+");
		addBotones("+/-");
		addBotones("0");
		addBotones(",");
		addBotones("=");
		
		
		add(display, BorderLayout.NORTH);
		add(panelBotones, BorderLayout.CENTER);
	}
	
	public void addBotones(String buttonName) {
		JButton button= new JButton(buttonName);
		panelBotones.add(button);
			
		if (buttonName.equals("")) button.setEnabled(false);
		else button.addActionListener(listener);		
	}

	class EventoBoton implements ActionListener {
		private double firstNumber= 0;
		private String operator= "";
		private boolean isNewNumber= true;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String selection= e.getActionCommand();
			
			if (selection.matches("\\d")) {
				if (isNewNumber) {
					display.setText(selection);
					isNewNumber= false;
				} else {
					display.setText(display.getText()+selection);
				}
				return;
			}
			
			if (selection.equals(",")) {
				if (!display.getText().contains(",")) {
					display.setText(display.getText()+",");
					isNewNumber= false;
				}
				return;
			}
			
			switch(selection) {
			case "+":
			case "-":
			case "*":
			case "/":
				firstNumber= getDisplay();
				operator= selection;
				isNewNumber= true;
				break;
			case "=":
				double secondNum= getDisplay();
				double result= calculate(firstNumber, secondNum, operator);
				display.setText(format(result));
				isNewNumber= true;
				break;
			case "C":
				display.setText("0");
				firstNumber= 0;
				operator= "";
				isNewNumber= true;
				break;
			case "DEL":
				String onDisplay= display.getText();
				if (!isNewNumber && display.getText().length()>0) {
					display.setText(
							display.getText().substring(0, display.getText().length()-1)
							);
					if (display.getText().isEmpty()) {
						display.setText("0");
						isNewNumber= true;
					}
				}
				break;
			case "CE":
				display.setText("0");
				isNewNumber= true;
				break;
			case "+/-":
				if (!display.getText().startsWith("-")) display.setText("-" + display.getText());
				else display.setText(display.getText().replace("-", ""));
				break;
			}			
		}
		public double getDisplay() {
			return Double.parseDouble(display.getText().replace(",", "."));
		}
		
		public double calculate(double a, double b, String op) {
			switch(op) {
			case "+": return a + b;
			case "-": return a - b;
			case "*": return a * b;
			case "/": return b == 0 ? 0 : a / b;
			default: return b;
			}
		}
		
		public String format(double value) {
			if (value == (int) value) {
				return String.valueOf((int) value);
			}
			return String.valueOf(value).replace(".", ",");
		}
	}
}

