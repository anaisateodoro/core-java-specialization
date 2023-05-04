package com.lq.generics;

import static java.lang.System.out;
import static com.lq.generics.GenericMethod.printArray;

public class GenericMethodExerciser {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		Double[] doubleArray = new Double[] { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character[] charArray = new Character[] { 'H', 'E', 'L', 'L', 'O' };
		
		out.print("Integers: ");
		printArray(intArray);
		out.print("Doubles: ");
		printArray(doubleArray);
		out.print("Characters: ");
		printArray(charArray);
	}
}
