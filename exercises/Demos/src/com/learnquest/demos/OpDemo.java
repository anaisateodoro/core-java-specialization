package com.learnquest.demos;

public class OpDemo {

	public static void main(String[] args) {
		/*
		 * The basic idea of +=, -=, *=, etc. can be explained as:
		 
		 		x op= y is equivalent to x = x op y
		 		
		 		e.g.,
		 		
		 		x += 5 is equivalent to x = x + 5
		 */
		
		int i = 10;
		int j = 12;
		
		i += j;
		
		System.out.println(i);

	}

}
