package ru.job4j.poly;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("Fly");
    }

    @Override
    public double speed() {
        return 1000;
    }
}
