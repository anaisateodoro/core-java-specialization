package com.lq.app;

import com.lq.enums.State;

public class StateTester {
	
	public StateTester(State state) {
		this.state = state;
	}
	
	private State state;

	public static void main(String[] args) {
		StateTester[] states = new StateTester[] {
				new StateTester(State.valueOf("NY")),
				new StateTester(State.valueOf("PA")),
				new StateTester(State.valueOf("SC")) /* ,
				new StateTester(State.valueOf("Confusion"))*/ };
		
		for (StateTester test: states) {
			System.out.printf("The capital of %s is %s%n", test.state.name(), test.state.getCapital());
		}
	}

}
