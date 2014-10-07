
// section 7 interactors

import acm.program.*;
import acm.graphics.*;

import java.util.*;

import java.awt.event.*;

import javax.swing.*;

//
public class sec7 extends GraphicsProgram {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int CX = 400;
	private static final int CY = 300;
	
	// set up layout of window
	public void init() {
		setSize(WIDTH , HEIGHT );
		// textfield and its label
		add(new JLabel("Name"), SOUTH);
		add(textField , SOUTH);
		// add buttons
		add(new JButton("Add"), SOUTH);
		add(new JButton("Remove"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		// event listeners
		addActionListeners();
		addMouseListeners();
	}
	
	// event callbacks
	public void actionPerformed(ActionEvent e) {
		// add a box
		if ( e.getActionCommand() == "Add" ){
			// get text from textfield
			String name = textField.getText();
			// console debugging
			println("add  " + name );
			// create new box from other class
			sec7Box box = new sec7Box(name);
			// add box to hashmap
			boxes.put( name, box );
			// add to canvas (centered)
			add(boxes.get(name) , CX-sec7Box.BOX_WIDTH/2, CY-sec7Box.BOX_HEIGHT/2);
		}
		if ( e.getActionCommand() == "Remove" ){
			// get correct box and remove
			String name = textField.getText();
			remove(boxes.get(name));
			// 
			println("remove " + name );
		}
		if ( e.getActionCommand() == "Clear" ){
			removeAll();
			//
			println("clear");
		}
	}
	
	// to get the coordinates of the initial mouse down to drag boxes
	public void mousePressed (MouseEvent e) {
		px = e.getX();
		py = e.getY();
		println("mouse pressed");
	}
	
	// allows the user to drag boxes
	public void mouseDragged (MouseEvent e) {
		// get the object it is at
		///// i am not sure why having this object as an instance variable makes it unable to be dragged. this way works fine though
		GObject gobj = getElementAt(px,py);
		// move box to new position if it exists
		if (gobj != null) { 
			gobj.move( e.getX() - px , e.getY() - py ) ;
		}
		// save coords for next drag
		px = e.getX();
		py = e.getY();
		println("mouse drageged");
	}
	
	// textfield for other functions to get its text
	private JTextField textField = new JTextField(50);
	// hashmap to keep track of new boxes
	private HashMap<String, GCompound> boxes = new HashMap<String, GCompound>();
	// to keep track of the mouse
	private int px;
	private int py;
}
