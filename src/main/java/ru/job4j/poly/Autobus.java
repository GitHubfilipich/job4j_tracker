package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ride on the road");
    }

    @Override
    public double speed() {
        return 120;
    }
}
