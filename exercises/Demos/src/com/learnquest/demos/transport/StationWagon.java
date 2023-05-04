package com.learnquest.demos.transport;

import static java.lang.Math.min;

public class StationWagon extends Cargo {
	
	public StationWagon() {
	}

	public StationWagon(String name) {
		super(name);
	}

	public StationWagon(String name, int speed, int fuel, boolean running) throws SpeedException {
		super(name, speed, fuel, running);
	}
	
	@Override
	public void setSpeed(int newSpeed) throws SpeedException {
		super.setSpeed(min(newSpeed, 50));
	}
}
