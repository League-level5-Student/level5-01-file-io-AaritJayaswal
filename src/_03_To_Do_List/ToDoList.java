package _03_To_Do_List;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JButton add = new JButton("add task");
	JButton view = new JButton("view tasks");
	JButton remove = new JButton("remove task");
	JButton save = new JButton("save list");
	JButton load = new JButton("load list");
	
	JPanel panel = new JPanel();

	JFrame frame = new JFrame();

	ArrayList<String> list = new ArrayList<String>();

	public ToDoList() {

		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		
		frame.add(panel);

		add.addActionListener(e -> addTask());

		view.addActionListener(e -> viewTasks());

		remove.addActionListener(e -> removeTask());
		
		save.addActionListener(e -> saveList());
		
		load.addActionListener(e -> loadList());
		
		frame.setVisible(true);
		
		frame.pack();

	}

	public void addTask() {
		String taskInput = JOptionPane.showInputDialog(null, "Enter a task: ");
		list.add(taskInput);

	}

	public void viewTasks() {
		JOptionPane.showMessageDialog(null, list);

	}

	public void removeTask() {
		String removeIndexString = JOptionPane.showInputDialog(null, "Enter the index of the task to remove");
		int removeIndex = Integer.parseInt(removeIndexString);
		list.remove(removeIndex);

	}

	public void saveList() {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/List", true);
			
			for (int i = 0; i < list.size(); i++) {
				fw.write("\n" + list.get(i));
			}
			
			fw.close();

		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void loadList() {
		
		String listLocation = JOptionPane.showInputDialog(null,"Enter the location of the list");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(listLocation));
			
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[]args) {
		
		new ToDoList();
	}

}

//Copyright © 2023 Aarit Jayaswal