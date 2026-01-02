package windowJCheckBoxJSlider;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UseJCheckBoxJSlider {
	public static void main(String[] args) {
		MyFrame frame1= new MyFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setBounds(400, 400, 600, 400);
		add(new MyLayer());
		setVisible(true);
	}
}

class MyLayer extends JPanel {
	private JLabel text;
	private JCheckBox bold, italic;
	private JSlider size;
	private JRadioButton small, medium, big, veryBig;
	
	public MyLayer() {
		setLayout(new BorderLayout());
		
		text= new JLabel("Texto de Prueba");
		text.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		text.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel south= new JPanel();
		bold= new JCheckBox("Bold");
		italic= new JCheckBox("Italic");
		size= new JSlider();
		size.setValue(30);
		size.setMinimum(10);
		size.setMaximum(70);
		size.setPaintTicks(true);
		size.setMinorTickSpacing(5);
		size.setMajorTickSpacing(10);
		size.setPaintLabels(true);
		
		small= new JRadioButton("12");
		medium= new JRadioButton("20");
		big= new JRadioButton("30");
		veryBig= new JRadioButton("40");
		
		ButtonGroup buttonGroup= new ButtonGroup();
		buttonGroup.add(small);
		buttonGroup.add(medium);
		buttonGroup.add(big);
		buttonGroup.add(veryBig);
		
		bold.addActionListener(new Listen());
		italic.addActionListener(new Listen());
		
		small.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Font labelText= text.getFont();
				text.setFont(new Font(labelText.getFamily(), labelText.getStyle(), 12));
				size.setValue(12);
			}
			
		});
		medium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Font labelText= text.getFont();
				text.setFont(new Font(labelText.getFamily(), labelText.getStyle(), 20));
				size.setValue(20);
			}
			
		});
		big.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Font labelText= text.getFont();
				text.setFont(new Font(labelText.getFamily(), labelText.getStyle(), 30));
				size.setValue(30);
			}
			
		});
		veryBig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Font labelText= text.getFont();
				text.setFont(new Font(labelText.getFamily(), labelText.getStyle(), 40));
				size.setValue(40);
			}
			
		});
		
		size.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Font labelText= text.getFont();
				text.setFont(new Font(labelText.getFamily(), labelText.getStyle(), size.getValue()));
			}
		});
		
		south.add(bold);
		south.add(italic);
		south.add(size);
		south.add(small);
		south.add(medium);
		south.add(big);
		south.add(veryBig);
		
		add(text, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);		
	}
	
	class Listen implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Font labelText= text.getFont();
			int style= Font.PLAIN;
			if (bold.isSelected()) style+= Font.BOLD;
			if (italic.isSelected()) style+= Font.ITALIC;
			text.setFont(new Font(labelText.getFamily(), style, labelText.getSize()));
		}
	}
}