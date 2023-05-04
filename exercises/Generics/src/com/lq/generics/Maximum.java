package com.lq.generics;

public class Maximum {
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;		// Assume, for now, that x is the max value
		
		max = y.compareTo(max) > 0 ? y : max;	// Replace max with y, if y > max
		max = z.compareTo(max) > 0 ? z : max;	// Replace max with y, if y > max
		
		return max;
	}
}
