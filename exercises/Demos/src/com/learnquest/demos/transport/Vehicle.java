package com.learnquest.demos.transport;

public interface Vehicle {
	public String getName();
	public void setName(String name);
	
	public int getSpeed();
	public void setSpeed(int newSpeed) throws SpeedException;

	public default void stop() {
		try {
			setSpeed(0);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public default void slow() {
		try {
			setSpeed(getSpeed() / 2);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void travelAtSpeedLimit(Vehicle vehicle) {
		try {
			vehicle.setSpeed(55);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
