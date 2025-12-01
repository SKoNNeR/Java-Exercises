package bbdd01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsultasBBDD {
	public static void main(String[] args) {
		BBDDFrame bbddFrame= new BBDDFrame();
		bbddFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class BBDDFrame extends JFrame {
	public BBDDFrame() {
		setTitle("Consultas BBDD");
		setBounds(600, 300, 600, 500);
		add(new BBDDLayer());
		setVisible(true);
	}
}

class BBDDLayer extends JPanel {
	private JComboBox<String> filter1, filter2;
	private JTextArea textArea;
	private JButton queryButton;
	private String pass;
	public BBDDLayer() {
		pass= JOptionPane.showInputDialog("What's the database password?");
		setLayout(new BorderLayout());
		
		JPanel north= new JPanel();
		
		filter1= new JComboBox<>();
		filter2= new JComboBox<>();
		
		filter1.setEditable(false);
		filter2.setEditable(false);
		
		textArea= new JTextArea();
		JScrollPane scrollPane= new JScrollPane(textArea);
		
		queryButton= new JButton("Query");
		
		getComboBox();
		
		queryButton.addActionListener(new QueryBBDD());
		
		north.add(filter1);
		north.add(filter2);
		
		add(north, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(queryButton, BorderLayout.SOUTH);
		
	}
	
	private void getComboBox() {
		try {
			filter1.addItem("All");
			Connection myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebasdef", "root", pass);
			Statement mySt= myCon.createStatement();
			ResultSet myRs= mySt.executeQuery("SELECT DISTINCT seccion FROM productos");
			while (myRs.next()) {
				filter1.addItem(myRs.getString(1));
			}
			myRs.close();
			
			filter2.addItem("All");
			ResultSet myRs2= mySt.executeQuery("SELECT DISTINCT pais_origen FROM productos");
			while (myRs2.next()) {
				filter2.addItem(myRs2.getString(1));
			}
			myRs2.close();
			mySt.close();
			myCon.close();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
	}
	
	class QueryBBDD implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String sentence= "SELECT nombre_articulo, seccion, precio, pais_origen FROM productos ";
				Connection myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebasdef", "root", pass);
				ResultSet myRs= null;
				PreparedStatement inSQL= null;
				
				if (filter1.getSelectedItem().toString().equals("All") && filter2.getSelectedItem().toString().equals("All")) {
					Statement mySt= myCon.createStatement();
					myRs= mySt.executeQuery(sentence);
					setText(myRs);
					mySt.close();
				} else if (!filter1.getSelectedItem().toString().equals("All") && !filter2.getSelectedItem().toString().equals("All")) {
						sentence+= "WHERE seccion=? AND pais_origen=?";
						inSQL= myCon.prepareStatement(sentence);
						inSQL.setString(1, filter1.getSelectedItem().toString());
						inSQL.setString(2, filter2.getSelectedItem().toString());
						myRs= inSQL.executeQuery();
						textArea.setText("");
						setText(myRs);
					} else if (!filter1.getSelectedItem().toString().equals("All")) {
						sentence+= "WHERE seccion=?";
						inSQL= myCon.prepareStatement(sentence);
						inSQL.setString(1, filter1.getSelectedItem().toString());
						myRs= inSQL.executeQuery();
						setText(myRs);
					} else if (!filter2.getSelectedItem().toString().equals("All")) {
						sentence+= "WHERE pais_origen=?";
						inSQL= myCon.prepareStatement(sentence);
						inSQL.setString(1, filter2.getSelectedItem().toString());
						myRs= inSQL.executeQuery();
						setText(myRs);
					}
				if (inSQL != null) inSQL.close();
				myRs.close();
				myCon.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void setText(ResultSet myRs) {
		try {
			textArea.setText("");
			while (myRs.next()) {
				textArea.append(myRs.getString(1) + ", " + myRs.getString(2)  + ", " + myRs.getString(3)  + ", " + myRs.getString(4) + "\n");
			}
			myRs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
