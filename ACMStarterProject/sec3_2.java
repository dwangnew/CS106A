import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;

public class sec3_2 extends GraphicsProgram {
	
	public void run() {
		setSize(800,600);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	public void mouseDragged(MouseEvent e) {
		remove(line);
		line = new GLine(x,y,e.getX(),e.getY());
		add(line);
	}
	
	private double x;
	private double y;
	private GLine line = new GLine(0,0,1,1);
}