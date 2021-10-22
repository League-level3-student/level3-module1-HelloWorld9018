package _07_California_Weather;

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
	CaliforniaWeather weather;
	JTextField textFieldMin = new JTextField();
	JTextField textFieldMax = new JTextField();
	JFrame frame1  = new JFrame();
	JPopups (CaliforniaWeather weather){
		this.weather = weather;
	}
	void duoInputPanel(){
		
		
		JPanel panel1 = new JPanel();
		JLabel labelMin = new JLabel("Min temperature:       ");
		JLabel labelMax = new JLabel("Max temperature: ");
		JLabel spacer = new JLabel("    ");
		
		JButton button  = new JButton("SEARCH");
		button.addActionListener(this);
		
		frame1.setTitle("Search by temperature");
		frame1.setPreferredSize(new Dimension(310, 130));
		
		//textFieldMin.setSize(1000, 10);
		textFieldMin.setPreferredSize(new Dimension(100, 20));
		textFieldMax.setPreferredSize(new Dimension(100, 20));
		
		Component[] myComponents = {labelMin, labelMax, textFieldMin, spacer, textFieldMax, button};
		
		frame1.add(panel1);
		
		for(int i = 0; i<myComponents.length; i++) {
			panel1.add(myComponents[i]);
		}
	
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	weather.calculateData(textFieldMin.getText() + "," + textFieldMax.getText(), 2);
		frame1.dispose();
	}
}
