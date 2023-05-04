package com.learnquest.demos.transport;

public class SUV extends Cargo {

	public SUV() {
	}

	public SUV(String name) {
		super(name);
	}

	public SUV(String name, int speed, int fuel, boolean running) throws SpeedException {
		super(name, speed, fuel, running);
	}
}
