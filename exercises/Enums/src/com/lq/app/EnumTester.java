package com.lq.app;

import com.lq.enums.TirePressures;

public class EnumTester {

	public static void main(String[] args) {
		
		TirePressures tp = TirePressures.valueOf("RR");
		tp.overridePressure(22);

		for (TirePressures t : TirePressures.values()) {
			System.out.println(t + " " + t.getPressure());
		}
	}
}
