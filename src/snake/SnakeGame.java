package snake;

import java.awt.Dimension;

import javax.swing.JFrame;

public class SnakeGame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeGame game= new SnakeGame();
	}
	
	public SnakeGame() {
		setTitle("Snake Game");
		
		setResizable(false);
		
		add(new GamePanel());
		
		pack();
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

