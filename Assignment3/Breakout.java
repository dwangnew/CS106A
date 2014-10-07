/*
 * File: Breakout.java
 * -------------------
 * Name: David W
 * Section Leader: None
 * 
 * This file will implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

//	array for the colors of the bricks
	private static final Color[] COLORS = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN};
	
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		setUpScreen();
		play();
	}

	// adds various objects to screen
	private void setUpScreen() {
		setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		addBricks();
		addPaddle();
		addBall();
	}
	
	// adds the rows of bricks
	private void addBricks() {
		for (int i = 0 ; i < NBRICK_ROWS ; i++ ) {
			int y = BRICK_Y_OFFSET + i*BRICK_HEIGHT + i*BRICK_SEP;
			// get a new color from the colors array for every 2 rows
			Color color = COLORS[(i/2) % 5];
			addRow(y, color);
		}
	}
	
	// adds one row of bricks
	private void addRow(double y, Color color) {
		for (int i = 0 ; i < NBRICKS_PER_ROW ; i++ ) {
			int x = i*BRICK_WIDTH + i*BRICK_SEP;
			GRect brick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
			brick.setColor(Color.WHITE);
			brick.setFillColor(color);
			brick.setFilled(true);
			add(brick);
		}
	}
	
	// adds the paddle
	private void addPaddle() {
		paddle = new GRect((WIDTH/2)-PADDLE_WIDTH/2, HEIGHT-PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFillColor(Color.BLACK);
		paddle.setFilled(true);
		add(paddle);
		addMouseListeners();
	}
	
	// mouse listener to track the movement of mouse to sync with the paddle
	public void mouseMoved(MouseEvent e) { 
		int x = e.getX();
		if ( x < PADDLE_WIDTH/2 ) {
			paddle.move(0 - paddle.getX() , 0 );
		} else if ( x > WIDTH - PADDLE_WIDTH/2 ) {
			paddle.move( WIDTH - PADDLE_WIDTH - paddle.getX() , 0);
		} else {
			paddle.move( x - paddle.getX() - PADDLE_WIDTH/2 , 0 );
		}
	}
	
	// adds a ball to screen and initializes the velocities
	private void addBall() {
		ball = new GOval(WIDTH/2 - BALL_RADIUS , HEIGHT/2 - BALL_RADIUS , 2*BALL_RADIUS, 2*BALL_RADIUS);
		ball.setFillColor(Color.BLACK);
		ball.setFilled(true);
		add(ball);
		Vx = rgen.nextDouble(0,3);
		if (rgen.nextBoolean()) {
			Vx = -Vx;
		}
		Vy = 3;
	}
	
	// starts the game
	private void play() {
		// check if game over i.e. the ball hits the bottom wall more than the number of lives
		while ( lives > 0 ) {
			moveBall();
			// check to see if all bricks are gone
			if (hasWon()) {
				add(new GLabel("YOU WON!" , WIDTH/2, HEIGHT/2));
				break;
			}
		}
	}
	
	// moves ball and checks for collisions
	private void moveBall() {
		pause(5);
		ball.move(Vx,Vy);
		checkCollisions();
	}
	
	// checks for collisions
	private void checkCollisions() {
		
		// Save ball's x, y for easy reference
		double x = ball.getX();
		double y = ball.getY();
		
		// check if ball hits either side walls
		// if yes, reverse the X velocity
		if ( x + 2*BALL_RADIUS > WIDTH || x < 0) {
			ball.move(-Vx,-Vy);
			Vx = -Vx;
		}
		
		// check if ball hits the top wall
		else if ( y < 0 ) {
			ball.move(-Vx,-Vy);
			Vy = -Vy;
		}
		
		// check if ball hits bottom wall
		else if ( y + 2*BALL_RADIUS  > HEIGHT - PADDLE_Y_OFFSET + PADDLE_HEIGHT) {
			lives--;
			remove(ball);
			pause(1000);
			addBall();
		}
		
		// check if ball hits an object
		else {
			// get the object where the ball is at, if any
			GObject collider = getCollidingObject(x,y,BALL_RADIUS);
			
			// reflect ball if it hits paddle
			if (collider == paddle) {
				ball.move(-Vx,-Vy);
				Vy = -Vy;
			} 
			// if hits brick, remove it and increase counter
			else if (collider != null) {
				ball.move(-Vx,-Vy);
				Vy = -Vy;
				remove(collider);
				count++;
			}
		}
	}
	
	
//	 return the first object found at any corner of the ball, or null
	private GObject getCollidingObject(double x, double y, double r) {
		GObject g1 = getElementAt(x, y);
		if (g1 != null) {
			return g1;
		}
		GObject g2 = getElementAt(x+2*r, y);
		if (g2 != null) {
			return g2;
		}
		GObject g3 = getElementAt(x, y+2*r);
		if (g3 != null) {
			return g3;
		}
		GObject g4 = getElementAt(x+2*r, y+2*r);
		if (g4 != null) {
			return g4;
		}
		return null;
	}
	
	// check to see if all bricks are gone
	private boolean hasWon() {
		if  ( count == NBRICK_ROWS * NBRICKS_PER_ROW ) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// count of number of bricks removed
	private int count = 0;
	// X component of velocity
	private double Vx;
	// Y "" "" ""
	private double Vy;
	// the paddle
	private GRect paddle;
	// ball
	private GOval ball;
	// variable to generate random values
	private RandomGenerator rgen = RandomGenerator.getInstance();
	// number of lives before game stops
	private int lives = 100*NTURNS;
}
