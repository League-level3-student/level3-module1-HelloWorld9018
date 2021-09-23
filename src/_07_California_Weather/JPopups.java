package _07_California_Weather;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPopups {
	void duoInputPanel(){
		JFrame frame1  = new JFrame();
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Min temperature:     ");
		JLabel label2 = new JLabel("Max temperature: ");
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JButton button  = new JButton("Enter");
		
		frame1.setVisible(true);
		
		frame1.add(panel1);
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(textField1);
		panel1.add(textField2);
		panel1.add(button);
	
	}
}
