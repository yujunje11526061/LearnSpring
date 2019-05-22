package com.car;

public class Audi implements Car {
    private String carName = Audi.class.getName();
    @Override
    public void start() {
        System.out.println(carName+": start");
    }

    @Override
    public void turnLeft() {
        System.out.println(carName+": turn left");
    }

    @Override
    public void turnRight() {
        System.out.println(carName+": turn right");
    }

    @Override
    public void stop() {
        System.out.println(carName+": stop");
    }
}
