package com.learnquest.demos.transport;

import java.time.LocalDate;
import java.time.Period;

import static java.lang.Math.min;

public abstract class Car implements Vehicle {

	public Car() { }

	public Car(String name)
	{
		// this(name, 0, 0, false);	// Can't use this if we don't want to declare SpeedException
		this(name, 0, false);
	}

	public Car(String name, int speed, int fuel, boolean running) throws SpeedException
	{
		this(name, 0, false);
		setSpeed(speed);
	}

	private Car(String name, int fuel, boolean running) {
		setName(name);
		setGasoline(fuel);
		setEngineState(running);
	}

	/*
	public void setTirePressures(int[] pressures)
	{
		
	}
	*/
	
	public void setTirePressures(int ... pressures)
	{
		
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// private static final int MAX_SPEED = 350;
	
	public abstract int getMaxSpeed();
	
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int newSpeed) throws SpeedException {
		// speed = min(newSpeed, MAX_SPEED);
		// speed = min(newSpeed, getMaxSpeed());
		if (newSpeed > getMaxSpeed()) {
			throw new SpeedException(String.format("%s cannot go %d mph.  Max speed is %d mph",
					getName(), newSpeed, getMaxSpeed()));
		}
		speed = newSpeed;
	}

	public int getGasoline() {
		return gasoline;
	}

	public void setGasoline(int gasoline) {
		this.gasoline = gasoline;
	}

	public boolean isEngineState() {
		return engineState;
	}

	public void setEngineState(boolean engineState) {
		this.engineState = engineState;
	}

	private int gasoline;
	private boolean engineState;
	
	private LocalDate manufactured;
	
	public LocalDate getManufactured() {
		return manufactured;
	}

	public void setManufactured(LocalDate manufactured) {
		this.manufactured = manufactured;
	}

	public int getAge() {
		return Period.between(getManufactured(), LocalDate.now()).getYears();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Car)) return false;
		
		Car other = (Car) obj;
		
		return name.equals(other.getName());
	}

	@Override
	public String toString() {
		if (manufactured == null)
			return String.format("%s is traveling at %d mph", getName(), getSpeed());
		else
			return String.format("%s is %d years old and is traveling at %d mph",
					getName(), getAge(), getSpeed());		
	}


}
