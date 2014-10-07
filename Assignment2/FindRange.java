/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		println("this program finds the max and min");
		int num = 1;
		int min = 2147483647;
		int max = -2147483648;
		while (num != 0) {
			num = readInt("?");
			if (num == 0 && max == -2147483648 && min ==2147483647) {
				println("you have entered the sentinel 0. quitting program");
				break;
			}
			if (num == 0) {
				println("max is: " + max);
				println("min is: " + min);
			}
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
	}
}

