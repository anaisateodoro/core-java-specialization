package com.devtech.training.transportation;

public class Train {

	public Train(String name) {
		setName(name);
		setWheelSize(60);	// Assume 5' diameter of the wheel
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return the locomotive's driving wheel's revolutions per minute
	 */
	public int getRPM() {
		return rpms;
	}
	
	/**
	 * 
	 * @param rpms the locomotive's driving wheel's revolutions per minute
	 */
	public void setRPM(int rpms) {
		this.rpms = rpms;
	}

	/**
	 * 
	 * @return the locomotive's driving wheel diameter in inches
	 */
	public int getWheelSize() {
		return wheel_size;
	}

	private void setWheelSize(int sz) {
		wheel_size = sz;
	}

	private String name;
	private int rpms;
	private int wheel_size;		// Wheel diameter in inches
}
