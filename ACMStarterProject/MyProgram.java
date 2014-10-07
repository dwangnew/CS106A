/* MyProgram.java
 * --------------
 * Modify this file any way you like (or create additional files in
 * the ACMStarterProject) in order to experiment with the capabilities
 * of the ACM libraries.
 * 
 * NOTE: While you are free to do whatever you like with this project,
 * it is still best to use the assignment-specific starter files
 * for actual assignments.
 */
import acm.program.*;
import acm.graphics.*;

//handout 12 checkboard
//public class MyProgram extends GraphicsProgram {
//	
//	private static final int NROWS = 8;
//	private static final int NCOLUMNS = 8;
//	
//	public void run() {
//		for (int i=0;i<NCOLUMNS;i++) {
//			drawRow(i);
//		}
//	}
//
//	private void drawRow(int height) {
//		for (int i=0;i<NCOLUMNS;i++) {
//			GRect sq = new GRect(20*i,20*height,20,20);
//			sq.setFilled(((i+height)%2 == 0));
//			add(sq);
//		}
//	}
//
//}


// section 2 #1 fibonacci
//public class MyProgram extends ConsoleProgram {
//
//	private static final int MAX = 10000;
//
//	public void run(){
//		int a = 0;
//		int b = 1;
//		int c;
//		while (b<MAX) {
//			c = a + b;
//			a = b;
//			b = c;
//			println(a);
//		}
//	}
//}


//sec2#2 face
public class MyProgram extends GraphicsProgram {
	
	private static final int HEAD_WIDTH = 150;
	private static final int HEAD_HEIGHT = 200;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 50;
	private static final int MOUTH_HEIGHT = 20;
	
	public void run() {
		double w = getWidth();
		double h = getHeight();
		draw_head(w/2,h/2);
		draw_eyes(w/2,h/2);
		draw_mouth(w/2,h/2);
	}
	
	private void draw_head(double w, double h) {
		add(new GRect(w,h,HEAD_WIDTH,HEAD_HEIGHT));
	}
	
	private void draw_eyes(double w, double h) {
		double w1 = w + .25*HEAD_WIDTH;
		double w2 = w +.75*HEAD_WIDTH;
		double h1 = h + .25*HEAD_HEIGHT;
		add(new GOval(w1,h1,EYE_RADIUS,EYE_RADIUS));
		add(new GOval(w2,h1,EYE_RADIUS,EYE_RADIUS));
	}
	
	private void draw_mouth(double w, double h) {
		
	}
	
}