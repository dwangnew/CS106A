/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		int side1 = readInt("Enter the first side of the triangle as an integer \n");
		int side2 = readInt("Enter second side \n");
		println("a: " + side1);
		println("b: " + side2);
		double a = (double)side1;
		double b = (double)side2;
		double c = Math.sqrt(exp(a,2) + exp(b,2));
		println("the third side is: " + c);
	}
	
	
	private double exp(double num, double power) {
		double total = 1;
		for (int i = 0; i<power; i++) {
			total = total * num;
		}
		return total;
	}
	
}
