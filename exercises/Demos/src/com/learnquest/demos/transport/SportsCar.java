package com.learnquest.demos.transport;

public class SportsCar extends Car {

	@Override
	public int getMaxSpeed() {
		return 350;
	}

	public SportsCar() {
	}

	public SportsCar(String name) {
		super(name);
	}

	public SportsCar(String name, int speed, int fuel, boolean running) throws SpeedException {
		super(name, speed, fuel, running);
	}

	@Override
	public void setSpeed(int newSpeed) throws SpeedException {
		super.setSpeed((int) (newSpeed * 1.10));
	}

	public void race() {
		try {
			setSpeed((int) (getMaxSpeed() / 1.10));
			// setSpeed(getMaxSpeed());
		} catch (SpeedException e) {
			System.out.printf("Unexpected error: we tried to race, but were told that the max speed was too fast.  See stack trace for details.%n");
			e.printStackTrace();
		}
	}

	/*
	private double speed;
	
	public void setSpeed(double newSpeed) {
		this.speed = newSpeed;
	}

public double getSpeed() {
		return speed;
	}
	*/
}
