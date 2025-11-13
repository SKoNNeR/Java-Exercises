package events.events4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExtendsListeners {
	public static void main(String[] args) {
		MyFrame f1= new MyFrame("Window 1", 150, 150, 600, 400);
		MyFrame f2= new MyFrame("Window 2", 300, 300, 600, 400);
		
		f1.setFrameIco("src/images/Glenn_Quagmire.png");
		f2.setFrameIco("src/images/Glenn_Quagmire.png");
		
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}


class MyFrame extends JFrame {
	private Image image;
	public MyFrame (String title, int xLoc, int yLoc, int xSize, int ySize) {
		setTitle(title);
		setBounds(xLoc, yLoc, xSize, ySize);
		add(new MyLayer());
		setVisible(true);
	}
	public void setFrameIco(String src) {
		Toolkit mySystem= Toolkit.getDefaultToolkit();
		Image imagen= mySystem.getImage(src);
		setIconImage(imagen);
	}
	
}

class MyLayer extends JPanel {
	JButton redButton= new JButton("RED");
	JButton greenButton= new JButton("GREEN");
	JButton blueButton= new JButton("BLUE");
	
	public MyLayer () {
		add(redButton);
		add(greenButton);
		add(blueButton);
		
		redButton.addActionListener(new ButtonEvent(Color.RED));
		greenButton.addActionListener(new ButtonEvent(Color.GREEN));
		blueButton.addActionListener(new ButtonEvent(Color.BLUE));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	class ButtonEvent implements ActionListener {
		private Color setBackgroundColor;

		public ButtonEvent (Color c) {
			setBackgroundColor= c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setBackground(setBackgroundColor);
		}
	}
}