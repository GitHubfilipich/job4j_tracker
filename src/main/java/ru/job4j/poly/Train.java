package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ride on rails");
    }

    @Override
    public double speed() {
        return 90;
    }
}
