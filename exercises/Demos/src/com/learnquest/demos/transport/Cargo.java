package com.learnquest.demos.transport;

public abstract class Cargo extends Car {
	public Cargo() {
		super();
	}

	public Cargo(String name) {
		super(name);
	}

	public Cargo(String name, int speed, int fuel, boolean running) throws SpeedException {
		super(name, speed, fuel, running);
	}

	@Override
	public int getMaxSpeed() {
		return 100;
	}

	@Override
	public void setSpeed(int newSpeed) throws SpeedException {
		// max(0, speed) ensures that we don't go negative.
		super.setSpeed(Math.max(0, newSpeed - getCurrentCargoLoad() / 100));
	}

	public void setCurrentCargoLoad(int currentCargoLoad) {
		this.currentCargoLoad = currentCargoLoad;
	}

	public int getCurrentCargoLoad() {
		return currentCargoLoad;
	}

	private int cargoCapacity;
	private int currentCargoLoad;

}