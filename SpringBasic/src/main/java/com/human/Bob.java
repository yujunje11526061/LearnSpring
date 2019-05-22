package com.human;

import com.car.Car;

public class Bob extends HumanWithCar {
    public Bob(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
