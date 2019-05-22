package com.human;

import com.car.Car;

public class Jack extends HumanWithCar {


    public Jack(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.stop();
    }
}
