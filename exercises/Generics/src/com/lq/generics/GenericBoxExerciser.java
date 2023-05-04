package com.lq.generics;

import static java.lang.System.out;

public class GenericBoxExerciser {

	public static void main(String[] args) {
		GenericBox<Integer> integerBox = new GenericBox<>();
		GenericBox<String> stringBox = new GenericBox<>();

		integerBox.setT(10);
		stringBox.setT("Hello World");
		
		out.printf("Integer: %d, String: %s%n", integerBox.getT(), stringBox.getT());
	}
}
