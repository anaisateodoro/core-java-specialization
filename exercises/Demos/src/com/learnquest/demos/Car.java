package com.learnquest.demos;
public class Car {
    public Car() {}
    public Car(int initialSpeed, boolean running) {
        setSpeed(initialSpeed);
        setRunning(running);
    }

    public int getSpeed() { return speed; }
    public void setSpeed(int s) { speed = s; }

    public Boolean isRunning() { return engineState; }
    public void setRunning(boolean state) { engineState = state; }
    private int speed;
    private boolean engineState;
}
