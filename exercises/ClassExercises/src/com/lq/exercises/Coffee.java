package com.lq.exercises;

public class Coffee {

	int temperature;
	
	public Coffee() {}  // Challenge Solution: no argument constructor leaves temperature at 0.

	public Coffee(int temperature) throws TooHotException {
		setTemperature(temperature);
	}
	
	public void setTemperature(int temperature) throws TooHotException {
		if (temperature > 120)
			throw new TooHotException(String.format("%d\u00B0F coffee would be too hot (> 120\u00B0F)", temperature));
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}
}
