package _08_World_Clocks;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

//MY NOTES: capitalize city name. use my own duo input jpopup for (city, country). create method that turns inputed country name into an acceptable acronym.

public class WorldClocks implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    JButton button; 
    JPopups popups;
    
    String city;
    String dateStr;
    String timeStr;
    
    int numOfClocks  = 1;
    String location;
    
    HashMap<String, TimeZone> timeZones = new HashMap<String, TimeZone>();
    
    public WorldClocks() {
        clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        
    /*    city = "Chicago, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        System.out.println(dateStr);
        */
        
        createGUI();
        
        // Sample starter program
        /*frame = new JFrame();
        panel = new JPanel();
        textArea = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.add(panel);
        panel.add(textArea);
        textArea.setText(city + "\n" + dateStr);*/
        
        // This Timer object is set to ctimeZonesHashmapall the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
    }
    
    
    public void createGUI() {
    /*	 Gives the user the ability to add a city to the display. One possible
    	 *    way to do this is to create a HashMap of city names and their
    	 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
    	 *    city's TimeZone to get the current date/time every second using a
    	 *    Timer object (see example code below). */
    	
    	
    	
    	frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Add Time Zone");
        
        button.addActionListener(this);
        
        frame.add(panel);
        panel.add(button);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
       
        for(String s: timeZones.keySet()) {
        	timeZone = timeZones.get(s);
        	Calendar calendar = Calendar.getInstance(timeZone);
        	String month  = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        	String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        	dateStr = dayOfWeek + " " + month + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        	//will it override previous textArea of will it add? May have to create arraylist of JtextAreas.
        	textArea = new JTextArea();
            textArea.setText(s + "\n" + dateStr);
            panel.add(textArea);
        }
        
     /*   for (int i = 1; i < numOfClocks; i++) {
        	textArea = new JTextArea();
      //  	textArea.setText(timesZones.keySet()[i] + "\n" + dateStr);
            panel.add(textArea);*/
          
        }
        
    //Work on JPopups. Make button show and work. Make button able to update createGUI to add new time zone clock. Allow user input in JPopup add to timeZones Hashmap. 

    @Override
    public void actionPerformed(ActionEvent arg0) {
     
        
        if(button == arg0.getSource()) {
        	numOfClocks++;
        	popups = new JPopups(this);
        	popups.duoInputPanel("Add New Time Zone", "City:", "Country:", "ENTER");
        }
        
        
        
    }
    
    
    void createNewClock(String city, String country){
    	System.out.println("adding new clock");
    	location = fixCapitalization(city, country);
    	
    	timeZone = clockUtil.getTimeZoneFromCityName(location);
    	timeZones.put(city, timeZone);
    	
    	Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        System.out.println(timeStr);
        textArea = new JTextArea();
        textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
        panel.add(textArea);
        ////////////////weird stuff I added rn
       // frame.pack();
    	//frame.setVisible(true);
    	//frame.dispose();
    	//createGUI();
    	
    }
    
    String fixCapitalization(String city, String country) {
    	String endCityLetters = "";
    	String firstCityLetter = city.substring(0);
    	firstCityLetter.toUpperCase();
    	for(int i = 1; i < city.length(); i++) {
    		endCityLetters+=city.charAt(i);
    	}
    	
    	String fixedCity = firstCityLetter + endCityLetters;
    	
    	String endCountryLetters = "";
    	String firstCountryLetter = country.substring(0);
    	firstCountryLetter.toUpperCase();
    	for (int i =  1; i<country.length(); i++) {
    		endCountryLetters += country.charAt(i);
    	}
    	
    	String fixedCountry = firstCountryLetter + endCountryLetters;
    	
    	String fixedLocation = fixedCity + ", " + fixedCountry;
    	
    	return fixedLocation;
    
    }
    
}
