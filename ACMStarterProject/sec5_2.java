// section 5 #2 displaying histogram from file

import java.io.*;
import acm.program.*;

//
public class sec5_2 extends ConsoleProgram {
	
	//
	public void run() {
		// create an array for each category of scores 0-9, 10-19, ... , 90-99, 100
		String[] scores = new String[11];
		// initialize each space in the array to be an empty string
		for (int i = 0 ; i < scores.length ; i++ ) {
			scores[i] = "";
		}
		
		
		// open file using try/catch block
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("MidtermScores.txt"));
		}
		catch (Exception e) {
			//
			println("error opening file");
		}
		// read lines using try catch block
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				// translate each string into an int
				int score = Integer.valueOf(line);
				// figure out which category the score is in;
				// then increment the appropiate category in the int[]
				scores[score/10] = scores[score/10] + "*";
			}
		}
		catch (Exception e) {
			//
			println("error reading line");
		}
		
		// output the totals for each category
		for (int i = 0 ; i < scores.length - 1 ; i++ ) {
			println(10*i + "-" + (10*i+9) + ": " + scores[i]);
		}
		// output the last category
		println("100:   " + scores[scores.length - 1]);
		
	}
}
