package _08_World_Clocks;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPopups implements ActionListener {
	
	  WorldClocks clocks;  
	
	  JFrame frame;
	  JPanel panel;
	  JLabel leftLabel;
	  JLabel rightLabel;
	  JLabel spacer;
	  JTextField leftInput;
	  JTextField rightInput;
	  JButton button;
	  Component[] myComponents = {leftLabel, rightLabel, leftInput, spacer, rightInput, button};
	  
	JPopups(WorldClocks clocks){
		this.clocks = clocks;
	}

  void duoInputPanel(String title, String leftPrompt, String rightPrompt, String buttonText){
	  
	  frame = new JFrame(title);
	  panel = new JPanel();
	  leftLabel = new JLabel(leftPrompt);
	  rightLabel = new JLabel(rightPrompt);
	  spacer = new JLabel("        ");
	  leftInput = new JTextField();
	  rightInput = new JTextField();
	  
	  frame.setPreferredSize(new Dimension(310, 130));
	  leftInput.setPreferredSize(new Dimension(100, 20));
	  rightInput.setPreferredSize(new Dimension(100, 20));
	  
	  button = new JButton("ENTER");
	  button.addActionListener(this);
	  
	  format();
  }

  void format() {
	  frame.add(panel);
		
		for(int i = 0; i<myComponents.length; i++) {
			panel.add(myComponents[i]);
		}
	
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
  }
  
  
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	clocks.createNewClock(leftInput.getText(), rightInput.getText());
	frame.dispose();
	
}
  
}