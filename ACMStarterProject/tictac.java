
// plays tic tac toe

import acm.program.*;

//
public class tictac extends ConsoleProgram {

	// constants
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 600;
	public static final String EMPTY = " ";
	public static final String X = "X";
	public static final String O = "O";
	
	// sets up screen/variables
	public void init() {
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		matrix = new String[3][3];
		// fill matrix with 0s
		for (int i = 0 ; i < 3 ; i++ ) {
			for (int j = 0 ; j < 3 ; j++ ) {
				matrix[i][j] = EMPTY;
			}
		}
	}
	
	// runs the program
	public void run() {
		println("Let's play Tic Tac Toe!");
		while (true) {
			String line = readLine("\nPress 1 to play: \n");
			if (line.equals("1")) {
				playGame();
			}
		}
	}
	
	// plays one game
	private void playGame() {
		displayGrid();
		while (!isGameOver()) {
			playRound();
		}
		println("Thanks for playing!");
	}
	
	// checks if game is over by seeing if each row or diagonal contains same letter
	private boolean isGameOver() {
		// checking if rows are the same
		for (int i = 0 ; i < 3 ; i++ ) {
			// horizontal rows
			if ( matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2]) && !matrix[i][0].equals(EMPTY) ) {
				println("Winner is player of the team " + matrix[i][0]);
				return true;
			}
			// vertical rows
			if ( matrix[0][i].equals(matrix[1][i]) && matrix[1][i].equals(matrix[2][i]) && !matrix[0][i].equals(EMPTY)) {
				println("Winner is player of the team " + matrix[0][i]);
				return true;
			}
		}
		// checking diagonals
		if ( matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2]) && !matrix[1][1].equals(EMPTY) ) {
			println("Winner is player of the team " + matrix[1][1]);
			return true;
		}
		if ( matrix[2][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[0][2]) && !matrix[1][1].equals(EMPTY) ) {
			println("Winner is player of the team " + matrix[1][1]);
			return true;
		}
		// game is not over if above 8 conditions not met
		return false;
	}
	
	// plays a round where one player chooses to mark a slot
	private void playRound() {
		String player = "";
		String mark = "";
		// player 1's turn (X)
		if (round % 2 == 0) {
			mark = readLine("Turn for player X. " +
					"Please enter the row and column where you would like to mark "
					+ "in the format \'row,column\'"
					+ "Ex.: 3,3 for the bottom right square \n");
			player = X;
		}
		// player 2's turn (O)
		else {
			mark = readLine("Turn for player O. " +
					"Please enter the row and column where you would like to mark "
					+ "in the 3 character format \'row,column\'. No spaces please. "
					+ "Ex.: 3,3 for the bottom right square \n");
			player = O;
		}
		
		int row = Character.getNumericValue(mark.charAt(0)) - 1;
		int column = Character.getNumericValue(mark.charAt(2)) - 1;
		
		// error checking for input
//		if (mark.length() != 3 || Integer.valueOf(mark.charAt(0)) > 3 || mark.charAt(0) < 0
//				|| mark.charAt(2) > 3 || mark.charAt(2) < 0)
		
		if ( matrix[row][column].equals(EMPTY) ) {
			matrix[row][column] = player;
		} else {
			println("square is taken. you lost your turn, dummy.");
		}
		
		displayGrid();
		
		round++;
	}
	
	// displays the text based graphical 3x3 grid
	private void displayGrid() {
		// loops through each row and prints it out
		for (int i = 0 ; i < 3 ; i++ ) {
			println( matrix[i][0] + " | " + matrix[i][1] + " | " + matrix[i][2] );
			// to separate the rows
			if (i < 2) {
				println("---------");
			}
		}
	}
	
	// instance vars
	private String[][] matrix;
	private int round = 0;
}
