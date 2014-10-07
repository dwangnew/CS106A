/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = 1;
		n = readInt("Enter a positive integer greater than 1 \n");
		int count = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				println("n is even so i take" + n + "/2 which is " + n/2);
				n = n/2;
			} else {
				println("n is odd so i take" + n + "*3 +1 which is " + 3*n + 1);
				n = 3*n + 1;
			}
			count++;
		}
		println("it took " + count + " steps to get to 1");
	}
}

