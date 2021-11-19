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
import javax.swing.SwingConstants;

public class JPopups implements ActionListener {
	
	  WorldClocks clocks;  
	
	  JFrame frame;
	  JPanel panel;
	  JLabel leftLabel;
	  JLabel rightLabel;
	  JLabel spacer1;
	  JTextField leftInput;
	  JTextField rightInput;
	  JButton button;
	  Component[] myComponents = new Component[6]; 
	  
	JPopups(WorldClocks clocks){
		this.clocks = clocks;
	}

  void duoInputPanel(String title, String leftPrompt, String rightPrompt, String buttonText){
	  
	  frame = new JFrame(title);
	  panel = new JPanel();
	  leftLabel = new JLabel(leftPrompt, SwingConstants.LEFT);
	  myComponents[0] = leftLabel;
	  rightLabel = new JLabel(rightPrompt);
	  myComponents[2] = rightLabel;
	  spacer1 = new JLabel("                  ");
	  myComponents[1] = spacer1;
	  leftInput = new JTextField();
	  myComponents[3] = leftInput;
	  rightInput = new JTextField();
	  myComponents[4] = rightInput;
	  
	  frame.setPreferredSize(new Dimension(250, 130));
	  leftInput.setPreferredSize(new Dimension(100, 20));
	  rightInput.setPreferredSize(new Dimension(100, 20));
	  
	  button = new JButton("ENTER");
	  button.addActionListener(this);
	  myComponents[5] = button;
	  //myComponents = {leftLabel, rightLabel, leftInput, spacer, rightInput, button};
	  format();
  }

  void format() {
	  frame.add(panel);
		
		for(int i = 0; i<myComponents.length; i++) {
			panel.add(myComponents[i]);
		}
		myComponents[0].setLocation(0,0);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
  }
  
  
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	frame.dispose();
	clocks.createNewClock(leftInput.getText(), rightInput.getText());
	
	
}
  
}