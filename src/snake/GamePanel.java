package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GamePanel extends JPanel{

	private enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	private Direction direction= Direction.RIGHT;

	private final int CELL_SIZE= 20;
	private final int COLS= 20;
	private final int ROWS= 20;
	private LinkedList<Point> snake;
	private Point food;
	private Timer timer;
	private boolean gameOver= false;
	
	
	
	public GamePanel() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(COLS*CELL_SIZE, ROWS*CELL_SIZE));
		setFocusable(true);
		setupKeyBindings();
		
		// CREAMOS EL LinkedList con Point para que guarde X e Y
		snake= new LinkedList<>();
		snake.add(new Point(10, 10)); // cabeza
		snake.add(new Point(9, 10)); // cuerpo
		snake.add(new Point(8, 10)); // cola
		
		// creamos comida
		spawnFood();

		// CREAMOS EL TIMER
		timer= new Timer(150, e-> {
			move();
			repaint();
		});
		timer.start();
		
		requestFocusInWindow();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		
		if (gameOver) {
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, COLS*CELL_SIZE, ROWS*CELL_SIZE);
			
			g2.setColor(Color.RED);
			g2.drawString("GAME OVER", (COLS*CELL_SIZE)/2-40, (ROWS*CELL_SIZE)/2-30);
			g2.drawString("(press R to reset)", (COLS*CELL_SIZE)/2-40, (ROWS*CELL_SIZE)/2-10);
			
			g2.setColor(Color.WHITE);
			g2.drawString("Final Score: " + (snake.size()-3), (COLS*CELL_SIZE)/2-40, (ROWS*CELL_SIZE)/2+10);
			return;
		}
		
		
			
		
		// pintamos snake
		g2.setColor(Color.DARK_GRAY);
		for (Point p: snake) {
			g2.fillRect(p.x*CELL_SIZE, p.y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
		}
		
		// comida
		g2.setColor(Color.RED);
		g2.fillRect(food.x*CELL_SIZE, food.y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
		
		int score= snake.size() -3;
		g2.setColor(Color.BLACK);
		g2.drawString("Score: " + score, 1, 11);
		
	}
	
	private void move() {
		
		if (gameOver) return;
		
		Point head= snake.getFirst();
		Point tail= snake.getLast();
				
		int newX= head.x;
		int newY= head.y;
		
		switch(direction) {
		case RIGHT -> newX++;
		case LEFT -> newX--;
		case UP -> newY--;
		case DOWN -> newY++;
		}
		
		if (newX < 0) newX= COLS - 1;
		if (newX >= COLS) newX= 0;
		if (newY < 0) newY= ROWS - 1;
		if (newY >= ROWS) newY= 0;
		
		Point newHead= new Point(newX, newY);
		
		boolean willEat= newHead.equals(food);
		boolean allowedTailMove= !willEat && newHead.equals(tail);
		boolean hitsBody= snake.contains(newHead) && !allowedTailMove;
		
		if (hitsBody) {
			gameOver= true;
			timer.stop();
			repaint();
			return;
		}
		
		snake.addFirst(newHead);
		
		
		if (!willEat) snake.removeLast();
		else {
			spawnFood();
		}

		
	}
	
	private void resetGame() {
		gameOver= false;
		direction= Direction.RIGHT;
		snake.clear();
		snake.add(new Point(10, 10)); // cabeza
		snake.add(new Point(9, 10)); // cuerpo
		snake.add(new Point(8, 10)); // cola
		spawnFood();
		timer.start();
		repaint();
	}
	
	private void spawnFood() {
		int foodX= (int) (Math.random() * COLS);
		int foodY= (int) (Math.random() * ROWS);		
		food= new Point(foodX, foodY);
		
		while (snake.contains(food)) {
			foodX= (int) (Math.random() * COLS);
			foodY= (int) (Math.random() * ROWS);	
			food.setLocation(foodX, foodY);				
		}
		
	}
	
	private void setupKeyBindings() {
		InputMap inputMap= getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap= getActionMap();
		
		KeyStroke up= (KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
		inputMap.put(up, "UP");
		actionMap.put("UP", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (direction == Direction.DOWN ) return; 
				direction= Direction.UP;
				
			}
		});
		
		KeyStroke down= (KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
		inputMap.put(down, "DOWN");
		actionMap.put("DOWN", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (direction == Direction.UP ) return; 
				direction= Direction.DOWN;
				
			}
		});
		
		KeyStroke left= (KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
		inputMap.put(left, "LEFT");
		actionMap.put("LEFT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (direction == Direction.RIGHT ) return; 
				direction= Direction.LEFT;
				
			}
		});
		
		KeyStroke right= (KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
		inputMap.put(right, "RIGHT");
		actionMap.put("RIGHT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (direction == Direction.LEFT ) return; 
				direction= Direction.RIGHT;
				
			}
		});
		
		KeyStroke reset= (KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));
		inputMap.put(reset, "RESET");
		actionMap.put("RESET", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (gameOver) resetGame();
			}
			
		});
		
	}
}
