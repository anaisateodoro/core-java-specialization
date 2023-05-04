package com.lq.exercises;

import static java.lang.System.out;

public class CoffeeExerciser {

	public static void main(String[] args) {
		Coffee coffee = null;
		try {
			coffee = new Coffee(125);
		} catch (TooHotException e) {
			out.println(e.getMessage());
			coffee = new Coffee();	// Challenge Solution: if coffee too hot, assign default coffee, which is OK.
		} finally {
			out.println("Coffee is set to " + coffee.getTemperature() + "\u00B0F");
		}
	}
}
