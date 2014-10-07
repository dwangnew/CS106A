
import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class sec3 extends GraphicsProgram {
	
	private static final int NUM_CIRCLES = 10;
	private static final int RADIUS_MIN = 5;
	private static final int RADIUS_MAX = 50;
	
	public void run() {
		
		setSize(800,600);
		
		for (int i = 0; i < NUM_CIRCLES; i++) {
			drawCircle();
		}
	}
	
	private void drawCircle(){
		double width = getWidth();
		double height = getHeight();
		int radius = rgen.nextInt(5, 50);
		double x = rgen.nextDouble(0,width-2*radius);
		double y = rgen.nextDouble(0,height-2*radius);
		GOval circle = new GOval(x,y,2*radius,2*radius);
		circle.setColor(rgen.nextColor());
		circle.setFilled(true);
		add(circle);
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
