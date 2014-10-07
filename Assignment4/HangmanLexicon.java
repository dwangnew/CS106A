/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	
	public int getWordCount() {
		readFile();
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	};
	

	private void readFile() {
		wordList = new ArrayList<String>();
		try {
			BufferedReader rd = new BufferedReader( new FileReader("HangmanLexicon.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				wordList.add(line);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	private ArrayList<String> wordList;
}
