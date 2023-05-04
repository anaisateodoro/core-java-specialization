package com.lq.enums;

public enum State {
	PA("Harrisburg"), SC("Columbia"), NY("Albany"), CA("Sacremento");	// Add any you want

	private State(String capital) {
		this.capital = capital;
	}
	
	public String getCapital() {
		return capital;
	}

	private String capital;
}
