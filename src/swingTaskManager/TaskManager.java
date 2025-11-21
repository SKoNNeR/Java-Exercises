package swingTaskManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TaskManager {
	public static void main(String[] args) {
		SwingTaskManager task= new SwingTaskManager();
	}
}

class Task {
	private String task;
	private boolean isDone;
	
	public Task(String task, boolean isDone) {
		this.task= task;
		this.isDone= isDone;
	}
	
	/* --------------------- OVERRIDE TOSTRING, JLIST WILL CALL --------------------- */
	@Override
	public String toString() {
		return task;
	}
	
	/* --------------------- SETTERS --------------------- */
	public void setTask(String task) {
		this.task= task;
	}
	public void setDone(boolean isDone) {
		this.isDone= isDone;
	}
	
	/* --------------------- GETTERS --------------------- */
	public String getTaskAndStatus() {
		if (this.isDone) return "The task: " + task + " is done.";
		else return "The task: " + task + " is not done.";
	}
	public String getTask() {
		return task;
	}
	public boolean getIsDone() {
		return isDone;
	}
}

class SwingTaskManager extends JFrame {
	public SwingTaskManager() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 400, 400, 600);
		add(new SwingTaskManagerLayer());
		setVisible(true);
	}
}

class SwingTaskManagerLayer extends JPanel {
	private JTextField textArea;
	private JButton taskButton, deleteButton;
	private DefaultListModel<Task> task;
	private JList taskList;
	
	public SwingTaskManagerLayer() {
		setLayout(new BorderLayout());
		
		/* --------------------- INSTACES --------------------- */
		textArea= new JTextField(20);
		taskButton= new JButton("ADD TASK");
		
		deleteButton= new JButton("Delete Task");
		
		task= new DefaultListModel<>();
		taskList= new JList(task);
		JScrollPane scrollPane= new JScrollPane(taskList);
		scrollPane.setPreferredSize(new Dimension(320, 450));
		
		/* --------------------- INSTANCES OF JPANEL --------------------- */
		JPanel north= new JPanel();
		JPanel center= new JPanel();
		JPanel south= new JPanel();
		
		/* --------------------- ADDING TO PANELS --------------------- */
		north.add(textArea);
		north.add(taskButton);
		
		center.add(scrollPane);
		
		south.add(deleteButton);
		
		
		/* --------------------- LISTENERS HERE --------------------- */
		taskButton.addActionListener(new ButtonEvent());
		deleteButton.addActionListener(new ButtonEvent());
		
		/* --------------------- ADDING PANELS TO LAYOUT --------------------- */
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
	}
	private class ButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == taskButton) {
				/* --------------------- ADD NEW TASK --------------------- */
				String newTask= textArea.getText();
				if (!newTask.trim().isEmpty()) {
					Task taskToAdd= new Task(newTask, false);
					task.addElement(taskToAdd);
					textArea.setText("");
				}				
			} else if (e.getSource() == deleteButton) {
				/* --------------------- CHECK AND DELETE TASK --------------------- */
				Task selectedTask= (Task) taskList.getSelectedValue();
				if (selectedTask != null) {
					task.removeElement(selectedTask);
				}				
			}
		}
	}
}