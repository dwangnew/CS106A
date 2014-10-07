/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	// not sure what this is
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	// self-explanatory
	public void run() {
		setUp();
		playGame();
	}
	
	// prompts user for number of players and the name of each player
	// then initializes the YahtzeeDisplay class with the right params
	private void setUp() {
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		while (nPlayers > MAX_PLAYERS) {
			nPlayers = dialog.readInt("Enter number of players - must be between 1 to 4");
		}
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		// initializes the YahtzeeDisplay class with the right params
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		
		// initializes the score array
		scores = new int[nPlayers][N_CATEGORIES];
	}

	// starts a game after YahtzeeDisplay is created
	private void playGame() {
		round = 12;
		while (!isGameOver()) {
			playRound();
		}
		endGame();
	}
	
	// checks to see if all 13 rounds have been played
	private boolean isGameOver() {
		if (round <= 13) return false;
		else return true;
	}
	
	// plays a round by looping for each player and calls the playTurn method for that player
	private void playRound() {
		for (int i = 0; i < nPlayers; i++) {
			playTurn(i+1);
		}
		// increases the round count after the round is finished for all players
		round++;
	}
	
	// plays a turn for player i
	private void playTurn(int player) {
		
		// message to start the turn
		display.printMessage("Round number " + String.valueOf(round) + ". "
				+ playerNames[player-1] + "'s turn. Please click Roll");
		
		// wait for player to click roll
		display.waitForPlayerToClickRoll(player);
		rollDice();
		display.displayDice(die);
		
		// waits for player to select dice to reroll
		display.waitForPlayerToSelectDice();
		reRollDice();
		display.displayDice(die);
		
		// does the above once again
		display.waitForPlayerToSelectDice();
		reRollDice();
		display.displayDice(die);
		
		// asks the player to select a category for scoring
		// then scores it and updates the scorecard
		int category  = display.waitForPlayerToSelectCategory();
		int score = calcScore(category);
		display.updateScorecard(category, player, score);
		
		// update score matrix
		scores[player-1][category-1] = score;
		
	}
	
	// generates random dice numbers - returns 5 member matrix of values 1-6
	private void rollDice() { 
		for ( int i = 0 ; i < N_DICE ; i++ ) {
			die[i] = rgen.nextInt(1, 6);
		}
	}
	
	// this function checks each die if it is selected
	// if so, it assigns it a new random value
	private void reRollDice() { 
		for ( int i = 0 ; i < N_DICE ; i++ ) {
			if (display.isDieSelected(i)) {
				die[i] = rgen.nextInt(1, 6);
			}
		}
	}
	
	// this function takes the category that the player chooses
	// and returns the score that the current dice configuration merits
	private int calcScore(int category) {
		
		// creates a hashmap of the array of die values
		HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
		for (int i = 0; i < 5; i++) {
			if (count.containsKey(die[i])) {
				count.put(die[i],count.get(die[i])+1);
			}
			else {
				count.put(die[i], 1);
			}
		}
		
		// if the player chooses any of the categories from ones to sixes,
		// this gives the score by multiplying that number with its frequency
		if (category <= SIXES) {
			if ( count.containsKey(category) ) {
				return count.get(category) * category;
			}
			else {
				return 0;
			}
		}
		
		// this divides up the rest of the categories
		switch (category) {
		
			// if there are 3 or 4 or 5 of any number showing, then it awards
			// points equal to the sum of everything
			case THREE_OF_A_KIND:
				int sum = 0;
				if ( count.containsValue(3) || count.containsValue(4) || count.containsValue(5) ) {
					for (int i = 0; i < 5 ; i++ ) {
						sum += die[i];
					}
				}
				return sum;

			// if there are 4 or 5 of any number showing, then it awards
			// points equal to the sum of everything
			case FOUR_OF_A_KIND:
				int sum1 = 0;
				if ( count.containsValue(4) || count.containsValue(5) ) {
					for (int i = 0; i < 5 ; i++ ) {
						sum1 += die[i];
					}
				}
				return sum1;
			
			// if there are exactly 3 of one value and 2 of another then
				// it's a full house
			case FULL_HOUSE:
				if ( count.containsValue(3) && count.containsValue(2) ) {
					return 25;
				}
				return 0;
			
			// possible small straight combinations are 1234, 2345, or 3456
			case SMALL_STRAIGHT:
				if ( count.containsKey(1) && count.containsKey(2) 
						&& count.containsKey(3) && count.containsKey(4) ) {
					return 30;
				}
				if ( count.containsKey(2) && count.containsKey(3) 
						&& count.containsKey(4) && count.containsKey(5) ) {
					return 30;
				}
				if ( count.containsKey(3) && count.containsKey(4) 
						&& count.containsKey(5) && count.containsKey(6) ) {
					return 30;
				}
				return 0;
			
			// possible large straight combinations are 12345, 23456
			case LARGE_STRAIGHT:
				if ( count.containsKey(1) && count.containsKey(2) 
						&& count.containsKey(3) && count.containsKey(4)
						&& count.containsKey(5) ) {
					return 40;
				}
				else if ( count.containsKey(2) && count.containsKey(3) 
						&& count.containsKey(4) && count.containsKey(5)
						&& count.containsKey(6) ) {
					return 40;
				}
				else {
					return 0;
				}
			
			// if there are 5 of any value
			case YAHTZEE:
				if ( count.containsValue(5) ) {
					return 50;
				}
				return 0;
				
			// returns the sum of everything. no checking needed
			case CHANCE:
				int sum2 = 0;
				for (int i = 0; i < 5 ; i++ ) {
					sum2 += die[i];
				}
				return sum2;
				
		}
		
		// return 0 if for some reason nothing above checks out
		return 0;
	}
	
	
	// counts scores, notifies winner
	private void endGame() {
		// add scores
		display.printMessage(String.valueOf(scores[0][0]));
		
		// crown victor
	}
	
	
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	
	private int[] die = new int[5];
	private int[][] scores;
	
	private int round;
	
}
