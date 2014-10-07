/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	private static final double OUTER_RADIUS = 72;
	private static final double MID_RADIUS = .65*72;
	private static final double INNER_RADIUS = .3*72;
	
	public void run() {
		double cx = getWidth()/2;
		double cy = getHeight()/2;
		drawOuter(cx,cy);
		drawMid(cx,cy);
		drawInner(cx,cy);
	}
	
	private void drawOuter(double cx, double cy) {
		GOval circle = new GOval(cx-OUTER_RADIUS,cy-OUTER_RADIUS,2*OUTER_RADIUS,2*OUTER_RADIUS);
		circle.setColor(Color.RED);
		circle.setFilled(true);
		add(circle);
	}
	
	private void drawMid(double cx, double cy) {
		GOval circle = new GOval(cx-MID_RADIUS,cy-MID_RADIUS,2*MID_RADIUS,2*MID_RADIUS);
		circle.setColor(Color.WHITE);
		circle.setFilled(true);
		add(circle);
	}
	
	private void drawInner(double cx, double cy) {
		GOval circle = new GOval(cx-INNER_RADIUS,cy-INNER_RADIUS,2*INNER_RADIUS,2*INNER_RADIUS);
		circle.setColor(Color.RED);
		circle.setFilled(true);
		add(circle);
	}
	
	
}
