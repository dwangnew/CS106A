/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 40;
	
	
	
	public void run() {
		setSize(800,400);
		double cx = getWidth()+200;
		double cy = getHeight();
		drawBoxes(cx,cy);
		drawLines(cx,cy);
	}


	private void drawBoxes(double cx, double cy) {
		drawBox(cx-.5*BOX_WIDTH,cy-1.5*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT, "Program");
		drawBox(cx-.5*BOX_WIDTH,cy+.5*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT, "ConsoleProgram");
		drawBox(cx-2*BOX_WIDTH,cy+.5*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT, "GraphicsProgram");
		drawBox(cx+BOX_WIDTH,cy+.5*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT, "DialogProgram");
		
	}

	private void drawBox(double x, double y, double width, double height, String text) {
		GRect box = new GRect(x,y,width,height);
		add(box);
		GLabel label1 = new GLabel(text,x,y);
		GLabel label = new GLabel(text, x+(.5*BOX_WIDTH)-(label1.getWidth()/2), y+(.5*BOX_HEIGHT)+(label1.getAscent()/2));
		add(label);
	}
	
	private void drawLines(double cx, double cy) {
		drawLine(cx,cy-.5*BOX_HEIGHT,cx,cy+.5*BOX_HEIGHT);
		drawLine(cx,cy-.5*BOX_HEIGHT,cx-1.5*BOX_WIDTH,cy+.5*BOX_HEIGHT);
		drawLine(cx,cy-.5*BOX_HEIGHT,cx+1.5*BOX_WIDTH,cy+.5*BOX_HEIGHT);
	}

	private void drawLine(double x1,double y1, double x2, double y2) {
		GLine line = new GLine(x1,y1, x2, y2);
		add(line);
	}
	
}

