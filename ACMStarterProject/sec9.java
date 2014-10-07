
// section 9 #2 expandable array

import java.awt.*;
import java.util.*;

public class sec9 {
	
	// constructor sets intial array to size provided and assign the object to its index
	public sec9(Object obj, int index) {
		arr = new Object[index+1];
		arr[index] = obj;
	}
	
	// returns null if index is out of bounds or the object
	public Object get(int index) {
		if ( index + 1 > arr.length ) {
			return null;
		}
		else {
			return arr[index];
		}
	}
	
	// if index greater than old array, returns a new array with all contents of old plus the new index and object
	// otherwise sets the object to the right index in old array
	public void set(Object obj, int index) {
		if (index + 1> arr.length) {
			Object[] newArr = new Object[index+1];
			newArr[index] = obj;
			for (int i = 0 ; i < arr.length ; i++) {
				newArr[i] = arr[i];
			}
		}
		else {
			arr[index] = obj;
		}
	}
	
	// instanc var
	private Object[] arr;
}
