package CalcuNator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalcuNator {
	public static void main(String[] args) {
		CalculatorFrame calc= new CalculatorFrame();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		ImageIcon ico = new ImageIcon(getClass().getResource("CalcuNator.png"));
		setIconImage(ico.getImage());
		setTitle("CalcuNator - A Calculator mixed with Terminator");
		setBounds(700, 300, 500, 500);
		add(new CalculatorLayer());
		setVisible(true);
		setResizable(false);
	}
}

class CalculatorLayer extends JPanel {
	private JLabel calcDisplay;
	private JPanel calcBody;
	private CalculatorBrain brain;

	public CalculatorLayer() {
		
		setLayout(new BorderLayout());
		
		calcDisplay= new JLabel("0");
		calcDisplay.setFont(new Font("Comic Sans", Font.BOLD, 80));
		calcDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		add(calcDisplay, BorderLayout.NORTH);
		
		calcBody= new JPanel();
		calcBody.setLayout(new GridLayout(5,4));
		add(calcBody, BorderLayout.CENTER);
		
		brain= new CalculatorBrain(calcDisplay);
		addButton("CE", brain);
		addButton("C", brain);
		addButton("DEL", brain);
		addButton("/", brain);
		addButton("7", brain);
		addButton("8", brain);
		addButton("9", brain);
		addButton("*", brain);
		addButton("4", brain);
		addButton("5", brain);
		addButton("6", brain);
		addButton("-", brain);
		addButton("1", brain);
		addButton("2", brain);
		addButton("3", brain);
		addButton("+", brain);
		addButton("", brain);
		addButton("0", brain);
		addButton(",", brain);
		addButton("=", brain);
		
		addKeyListener(brain);
		setFocusable(true);
		
	}
	
	public void addButton(String name, CalculatorBrain listener) {
		JButton button= new JButton(name);
		calcBody.add(button);
		button.addActionListener(listener);
		button.setFocusable(false);
	}
	
	private class CalculatorBrain extends KeyAdapter implements ActionListener {
		private double result;
		private String lastOperation;
		private boolean isNewNum= true;
		private JLabel display;
		
		public CalculatorBrain(JLabel display) {
			this.display= display;
		}
		
		private void setDel() {
			String numsDisplay= display.getText();
			if(numsDisplay.length()>1) {
				numsDisplay= numsDisplay.substring(0, numsDisplay.length()-1);
				display.setText(numsDisplay);
			} else {
				display.setText("0");
				isNewNum= true;
			}
		}
		private void setCe() {
			display.setText("0");
			isNewNum= true;
		}
		private void setC() {
			result=0;
			display.setText("0");
			isNewNum= true;
			lastOperation= "";
		}
		private void updateNum() {
			result = Double.parseDouble(display.getText());
			isNewNum = true;
		}
		
		private void processOperation(String cmd) {
			Double num;
			try {
				if (cmd.equals("")) return;
				if (cmd.equals(",")) {
					if (!display.getText().contains(".")) {
						display.setText(display.getText() + ".");
					}
					return;
				}
				num= Double.parseDouble(cmd);			
				if (isNewNum) {
					display.setText(cmd);
					isNewNum= false;
				} else {
					display.setText(display.getText()+cmd);
				}
			} catch (NumberFormatException ne) {
				if (cmd.equals("DEL")) setDel();
				else if (cmd.equals("CE")) setCe();
				else if (cmd.equals("C")) setC();
				else if (cmd.equals("-")) {
					updateNum();
					lastOperation= "-";
				}
				else if (cmd.equals("+")) {
					updateNum();
					lastOperation= "+";
				}
				else if (cmd.equals("*")) {
					updateNum();
					lastOperation= "*";
				}
				else if (cmd.equals("/")) {
					updateNum();
					lastOperation= "/";
				}
				else if (cmd.equals("=")) {
					if (lastOperation != null) {						
						double secondNumber = Double.parseDouble(display.getText());
						if (lastOperation.equals("+")) result= result+ secondNumber;						
						else if (lastOperation.equals("-")) result= result- secondNumber;
						else if (lastOperation.equals("*")) result= result* secondNumber;
						else if (lastOperation.equals("/")) {
							if (secondNumber==0) JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
							else result= result/ secondNumber;
						}
						display.setText("" + result);
					}
					isNewNum= true;
				}
			}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) processOperation("=");
			else if (e.getKeyCode() == KeyEvent.VK_DELETE) processOperation("C");
			else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) processOperation("DEL");
			else if (e.getKeyCode() == KeyEvent.VK_DECIMAL) processOperation(",");
			else {
				char c= e.getKeyChar();
				String numString= String.valueOf(c);
				processOperation(numString);				
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
		    processOperation(cmd);
		}
	}
}
