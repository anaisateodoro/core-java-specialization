package com.learnquest.demoapps;

import com.learnquest.demos.Months;

public class EnumDemo {

	public static void main(String[] args) {

		for (Months month: Months.values())
			System.out.printf("%d days hath %s%n", month.getDaysInMonth(), month);
	}
}
