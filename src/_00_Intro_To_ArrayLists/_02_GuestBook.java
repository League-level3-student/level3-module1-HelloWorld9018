package _00_Intro_To_ArrayLists;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	JButton add;
	JButton read; 
	ArrayList <String> names = new ArrayList<String>();
	
	_02_GuestBook() {
		JFrame frame = new JFrame();
		frame.setTitle("Guest Book");
	
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 35));
		add = new JButton();
		read = new JButton();
		
		frame.add(panel);
		panel.add(add);
		panel.add(read);
		add.setText("Add Name");
		read.setText("View Name");
		
		frame.pack();
		
		add.addActionListener(this);
		read.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JButton button  = new JButton();
		if(e.getSource() == add) {
			String name = JOptionPane.showInputDialog("Enter name: ");
			names.add(name);
		}
		else {
			String holder = "Guest #1: " + names.get(0) + "\n";
			for(int i = 0; i<names.size() -1; i++) {
				String message = "Guest #" + (i+2) +": " + names.get(i+1) + "\n";
				holder = holder + message;
				
			}
			JOptionPane.showMessageDialog(null, holder);
		}
	}
	
	
}
