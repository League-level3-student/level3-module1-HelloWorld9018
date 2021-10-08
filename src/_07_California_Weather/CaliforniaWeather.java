package _07_California_Weather;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 °F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather implements ActionListener {
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	JPopups pops = new JPopups(this);
	WeatherData datum;
    void start() {
    	
        // All city keys have the first letter capitalized of each word
        String cityName = Utilities.capitalizeWords( "National City" );
         datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        
        createGUI();
    }
    
   
    
    HashMap<String, JButton> buttonNameMatcher = new HashMap <String, JButton>();
    JButton[] myButtons = new JButton[3];
    
    void createGUI() {
    	
    	//initailizing Jcomponents
    	JFrame frame  = new JFrame("California Weather");
    	frame.setVisible(true);
    	
    	JPanel panel = new JPanel();
    	JLabel label = new JLabel("Search by...");
    	
    	frame.add(panel);
    	
    	panel.add(label);
    	
    	
    	String[] buttonNames = {"City", "Weather Condition", "Temperature"};
    	
    	
    	for(int i = 0; i < myButtons.length; i++) {
    		myButtons[i] = new JButton(buttonNames[i]);
    		myButtons[i].addActionListener(this);
    		panel.add(myButtons[i]);
    		buttonNameMatcher.put(buttonNames[i], myButtons[i]);
    	}
   
    	
    	//frame.setSize(new Dimension(500, 110));
    	frame.pack();
    	
    	//option dialog
    	//or button/gui
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton selectedButton = (JButton) e.getSource();
		if(buttonNameMatcher.get("City") == selectedButton) {
			
			System.out.println("City is pressed");
			String cityName = JOptionPane.showInputDialog("Enter a city name in the textbox below");
			calculateData (cityName, 0);
			
		}
		else if(buttonNameMatcher.get("Weather Condition") == selectedButton) {
			System.out.println("weather is pressed");
			String weatherCondition  = JOptionPane.showInputDialog("Enter a weather condition in the textbox below");
			calculateData(weatherCondition, 1);
		}
		else {
			System.out.println("temperature is pressed");
			
	        pops.duoInputPanel();
			
		}
		
	}
	
	void calculateData (String input, int type) {
		if(type == 0) {
			//correct spelling?
			String fixedCityName = Utilities.capitalizeWords(input);
			datum = weatherData.get(fixedCityName);
			if( datum == null ) {
            JOptionPane.showMessageDialog(null, "Unable to find weather data for: \"" + fixedCityName + "\"", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
            JOptionPane.showMessageDialog(null, fixedCityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F", "Search Results for: " + fixedCityName , JOptionPane.PLAIN_MESSAGE);
        }
		
		}
		else if(type == 1) {
			String fixedCondition = Utilities.capitalizeWords(input);
			String cityList = "";
			int lineLength = 0;
			//datum = weatherData.get(fixedCondition);
			for(String c: weatherData.keySet()) {
				
				if(weatherData.get(c).weatherSummary.equals(fixedCondition)) {
					cityList+= c + ", ";
					lineLength++;
				}
			}
			JOptionPane.showMessageDialog(null, cityList);
			//JOptionPane.showMessageDialog(null, weatherData.containsKey(fixedCondition));
		}
		else if(type == 2) {
			
		}
		
	}
	
}
