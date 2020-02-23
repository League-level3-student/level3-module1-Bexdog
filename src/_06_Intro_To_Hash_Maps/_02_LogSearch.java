package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	private int[] id;
	private String[] name;
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton search;
	JButton view;
	JButton remove;
	JButton clear;
	_02_LogSearch(){
	name = new String[0]; 
	id = new int[0]; 
	frame = new JFrame();
	panel = new JPanel();
	add = new JButton();
	search = new JButton();
	view = new JButton();
	remove = new JButton();
	clear = new JButton();
	frame.add(panel);
	panel.add(add);
	panel.add(search);
	panel.add(remove);
	panel.add(view);
	panel.add(clear);
	add.addActionListener(this);
	search.addActionListener(this);
	view.addActionListener(this);
	remove.addActionListener(this);
	clear.addActionListener(this);
	add.setText("Add Entry");
	search.setText("Search by ID");
	view.setText("View List");
	remove.setText("Remove Entry");
	clear.setText("Clear List");
	frame.setVisible(true);
	frame.pack();
	}
	public static void main(String[] args) {
		_02_LogSearch log = new _02_LogSearch();
	}
	public void put(String names, int ids) {
		//A. iterate through the keys. If you find a key that matches
		//   the passed in String, set the value at that location to the
		//   passed in value and return from the method.
		for(int i = 0; i<name.length;i++) {
			if(name[i]==names) {
				id[i] = ids;
				return;
			}
		}
		//B. create a String array that is one element longer than the keys
			String[] newName = new String[name.length+1];
		//C. create an integer array that is one element longer than values
			int[] newId = new int[id.length+1];
		//D. set the last element of the new String array to the passed in key
			newName[newName.length-1] = names;
		//E. set the last element of the new int array to the passed in value
			newId[newId.length-1] = ids;
		//F. iterate through the keys and values and copy the elements to the new arrays
			for(int i =0;i<name.length;i++) {
				newName[i] = name[i];
			}
			for(int i =0;i<id.length;i++) {
				newId[i] = id[i];
			}
		//G. Set the keys and values arrays equal to the new arrays created in steps B and C.
			name = newName;
			id = newId;
		
	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String Ids;
			int ids;
			String names;
			Ids = JOptionPane.showInputDialog("Please enter an ID number");
			ids = Integer.parseInt(Ids);
			names = JOptionPane.showInputDialog("Now enter a name corresponding with that ID number");
			put(names, ids);
		}
		else if(e.getSource() == search) {
			boolean found = false;
			int input;
			String Input;
			Input = JOptionPane.showInputDialog("Please enter an ID number");
			input = Integer.parseInt(Input);
			
				int i;
				for(i = 0; i<id.length;i++) {
					if(id[i]==input) {
						found = true;
						break;
					}
				}
				if(found){
					JOptionPane.showMessageDialog(null, name[i]);
				}
				else {
					JOptionPane.showMessageDialog(null, "That ID number doesn't exist");
				}
				
				
			
		}
		else if(e.getSource() == view) {
			String output = "";
			for(int i = 0; i<name.length;i++) {
				output = output + "ID: "+id[i]+" Name: "+ name[i]+"\n";
			}
			JOptionPane.showMessageDialog(null, output);
		}
		else if(e.getSource() == remove) {
			boolean found = false;
			int input;
			String Input;
			Input = JOptionPane.showInputDialog("Please enter an ID number");
			input = Integer.parseInt(Input);
			
				int i;
				for(i = 0; i<id.length;i++) {
					if(id[i]==input) {
						found = true;
						break;
					}
				}
				if(found){
					String[] newName = new String[name.length-1];
					int[] newId = new int[id.length-1];
					if(input>1) {
					for(int j = 0; j<input; j++) {
						newName[j] = name[j];
						newId[j] = id[j];
					}
					}
					for(int j = input+1; j<name.length; j++) {
						newName[j] = name[j];
						newId[j] = id[j];
					}
					
					name = newName;
					id = newId;
				}
				else {
					JOptionPane.showMessageDialog(null, "That ID number doesn't exist");
				}
		}
		else if(e.getSource()==clear) {
			String[] newName = new String[0];
			int[] newId = new int[0];
			name = newName;
			id = newId;
		}
	}
	
}
