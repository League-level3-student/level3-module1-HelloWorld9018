package _07_California_Weather;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class CaliforniaWeather {
    
    void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
        String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        
        createGUI();
    }
    
    JPanel panels;
    
    final static String TEXTPANEL = "Card with JTextField";
    final static String BUTTONPANEL = "Card with JButtons";
    final static String SEARCHPANEL = "Card with search button";
    
    
    void createGUI() {
    	
    	//initailizing Jcomponents
    	JFrame frame  = new JFrame("California Weather");
    	frame.setVisible(true);
    	
    	panels = new JPanel();
    	JLabel label = new JLabel("Filter results by...");
    	
    	JPanel panelText = new JPanel();
    	JPanel panelButtons = new JPanel();
    	JPanel panelSearch = new JPanel();
    	
    	JButton button1 = new JButton("City");
    	JButton button2 = new JButton("Weather Condition");
    	JButton button3 = new JButton("Temperature");
    	JButton button4 = new JButton("SEARCH");
    	
    	//titling Jcompononets
    	/*frame.setTitle("California Weather");
    	
    	label.setText("Filter results by...");
    	
    	button1.setText("City");
    	button2.setText("Weather Condition");
    	button3.setText("Temperature");
    	
    	button4.setText("SEARCH");*/
    	
    	//Adding JComponents
  
    	frame.add(panels);
    	//panels.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
    	panels.add(label);
    	panels.add(button1);
    	panels.add(button2);
    	panels.add(button3);
    	panels.add(button4);
    	
   /* 	panels.add(panelText, TEXTPANEL);
    	panels.add(panelButtons, BUTTONPANEL);
    	panels.add(panelSearch, SEARCHPANEL);*/
    	
    	frame.pack();
    	//panels.setLayout(new CardLayout());

    	
    	
    	//frame.pack();
    	
    	//option dialog
    	//or button/gui
    }
}
