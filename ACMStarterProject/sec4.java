
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// #1
//public class sec4 extends ConsoleProgram {
//
//	public void run() {
//		while (true) {
//			String num = readLine("Enter an integer");
//			String str = addCommasToNumericString(num);
//			println(str);
//		}
//		
//	}
//	
//	private String addCommasToNumericString(String num) {
//		if (num.length() < 4) {
//			return num;
//		}
//		else {
//			String newStr = "";
//			newStr = newStr + num.substring(0,num.length()%3);
//			for (int i = 0; i<num.length()/3 ; i++) {
//				if (newStr.length() != 0) {newStr = newStr + ",";}
//				newStr = newStr + num.substring(3*i+num.length()%3,3*i+3+num.length()%3);
//			}
//			return newStr;
//		}
//	}
//}

public class sec4 extends ConsoleProgram {
	public void run() {
		while (true) {
			String str = readLine("Enter a string");
			String letter = readLine("Enter a letter");
			char l = letter.charAt(0);
			String nStr = removeLetter(str, l);
			println(nStr);
		}
	}
	
	private String removeLetter(String str, char letter) {
		String nStr = "";
		for (int i = 0 ; i < str.length() ; i++ ) {
			if (str.charAt(i) != letter) {
				nStr = nStr + str.charAt(i);
			}
		}
		return nStr;
	}
}
