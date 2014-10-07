// section 5 #3 unique names
// I dont know why the sentinel doesn't work!!!


import java.io.*;
import acm.program.*;
import java.util.*;

//
public class sec5_3 extends ConsoleProgram {
	
	//
	public void run() {
		// prompt user for names
		while (true) {
			String name = readLine("Please enter a name. Enter a space to quit \n");
			//sentinel 
			if (name.equals("")) break;
			// add name if not already there
			if (list.contains(name)){
				println("name already entered" + "-->" + name + "<--" + "length" + name.length() );
			} else {
				list.add(name);
			}
		}
		// output all in list of names
		println("List of names: ");
		for (int i = 0 ; i < list.size() ; i++ ) {
			println(list.get(i));
		}
		
	}
	
	private ArrayList<String> list = new ArrayList<String>();
	
}