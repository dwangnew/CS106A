/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		setSize(800,600);
		drawPyr();
	}
	
	private void drawPyr() {
		double cx = getWidth()/2;
		double y = getHeight();
		for (int i = BRICKS_IN_BASE; i>0; i--) {
			drawRow(i,cx-(BRICK_WIDTH*i/2),y-((16-i)*BRICK_HEIGHT));
		}
	}
	
	private void drawRow(int numBricks, double x, double y) {
		for (int i = 0; i<numBricks; i++) {
			GRect brick = new GRect(x+i*BRICK_WIDTH,y,BRICK_WIDTH,BRICK_HEIGHT);
			add(brick);
		}
	}
	
}

