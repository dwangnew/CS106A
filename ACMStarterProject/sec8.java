
// section 8

import acm.program.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class sec8 extends ConsoleProgram {
	
	// runs the program
	public void run() {
		
		// increase size of window
		setSize( 800,600 );
		
		// greeting
		println("Welcome to your travel agent. Please select starting city");
		
		// init db as hashmap from file - fills in entries into hashmap 'routes'
		createRoutes();
		
		// prints list of starting cities by iterating over hashmap's keys
		Iterator iterator = routes.keySet().iterator();
		while (iterator.hasNext()) {
			println(iterator.next());
		}
		
		// get initial starting city
		String startingCity = readLine("Pick a city from the list above to go to: \n");
		visited.add(startingCity);
		
		// main loop:
		while (true) {
			println("You are current at " + startingCity);
			if (startingCity.equals("")) break;
			showRoutes(startingCity);
			startingCity = readLine("Pick a city from the list above to go to: \n");
			visited.add(startingCity);
		}
		
		println("\n You have visited: ");
		Iterator iter = visited.iterator();
		while (iter.hasNext()) {
			println(iter.next());
		}
		
	}
	
	// reads file and fills in the routes hashmap
	private void createRoutes() {
		
		// open file using try/catch block
		BufferedReader rd = null;
		
		try {
			rd = new BufferedReader(new FileReader("routes.txt"));
		}
		catch (Exception e) {
			//
			println("error opening file");
		}
		
		// read lines using try catch block
		try {
			while (true) {
				String fullLine = rd.readLine();
				if (fullLine == null) break;
				
				// following commented out code is for a text file in which each line was separated into 3 lines somehting like San Jose \n - \n > San Francisco
//				for (int i = 0 ; i < 2 ; i ++ ) {
//					String line = rd.readLine();
//					if (line == null) break;
//					fullLine = fullLine + line;
//				}
				
				// passed line to function that reads each line
				createRoute(fullLine);
			}
		}
		catch (Exception e) {
			//
			println("error reading line");
		}
	}
	
	// fills in one entry into hashmap routes using a line from the file
	private void createRoute(String line) {
		// finds index of the starting and ending cities in the line
		int startingCityEndIndex = line.indexOf("-") -1 ;
		int endCityStartingIndex = line.indexOf(">") + 1 ;
		// extracts the cities from the line
		String startingCity = line.substring(0, startingCityEndIndex);
		String endingCity = line.substring(endCityStartingIndex);
		// updates ending cities if key exists, else
		// enters a new key;value pair
		if (routes.containsKey(startingCity)) {
			routes.get(startingCity).add(endingCity);
		}
		else {
			ArrayList<String> destinations = new ArrayList<String>();
			destinations.add(endingCity);
			routes.put(startingCity, destinations);
		}
	}
	
	// shows routes given a starting city
	private void showRoutes(String city) {
		// iterates over the arraylist of ending cities
		if (routes.get(city) != null) {
			Iterator iterator = routes.get(city).iterator();
			while (iterator.hasNext()) {
				println(iterator.next());
			}
		}
	}
	
	// instance vars
	private HashMap<String,ArrayList<String>> routes  = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> visited = new ArrayList<String>();
}
