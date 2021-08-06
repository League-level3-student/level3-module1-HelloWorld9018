package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */

	HashMap <Integer, String> IDlog = new HashMap <Integer, String>();
	
	JButton add;
	JButton search;
	JButton view;
	JButton remove;
	
	public void createGUI() {
		JFrame frame  = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setTitle("Log Search");
		frame.add(panel);
		
		add = new JButton();
		search = new JButton();
		view = new JButton();
		remove = new JButton();
		
		add.setText("Add Entry");
		search.setText("Search by ID");
		view.setText("View List");
		remove.setText("Remove Entry");
		
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		
		frame.pack();
		
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new _02_LogSearch().createGUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		//ADD ENTRY---------------------------------------------------------
		if(e.getSource().equals(add)) {
			System.out.println("add is working");
			String ID = JOptionPane.showInputDialog("Enter an ID number");
			int numID = Integer.parseInt(ID);
			String name  = JOptionPane.showInputDialog("Enter a name");
			IDlog.put(numID, name);
		}
		
		
		//SEARCH BY ID------------------------------------------------------
		else if(e.getSource().equals(search)) {
			System.out.println("search is working");
			String searchID = JOptionPane.showInputDialog("Enter an ID number");
			int numSearchID = Integer.parseInt(searchID);
			
			if(IDlog.containsKey(numSearchID)) {
				
				JOptionPane.showMessageDialog(null, IDlog.keySet() + ",  " + IDlog.get(numSearchID), "ID search results", JOptionPane.PLAIN_MESSAGE);
				//JOptionPane.showmess
			}
			else {
				JOptionPane.showMessageDialog(null, "The entry " + "'" + searchID + "'" + " does not exist", "ID search results", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		
		//VIEW LIST--------------------------------------------------------
		else if(e.getSource().equals(view)) {
			System.out.println("view is working");
			String holder = "";
			
			for(Integer i: IDlog.keySet()) {
				holder += "ID: "+ i + " ,  Name: " + IDlog.get(i) + "\n";
			
			}
			
			JOptionPane.showMessageDialog(null, holder, "View List", JOptionPane.PLAIN_MESSAGE);
			
		}
		
		
		//REMOVE ENTRY-------------------------------------------------------
		else{
			System.out.println("Remove is working");
			
			String removeID = JOptionPane.showInputDialog("Enter an ID number");
			int numRemoveID = Integer.parseInt(removeID);
			
			if(IDlog.containsKey(numRemoveID)) {
				IDlog.remove(numRemoveID);
				JOptionPane.showMessageDialog(null, "ID removed sucessfully", "Remove Entry", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "The entry " + "'" + removeID + "'" + " does not exist", "ID search results", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
}
