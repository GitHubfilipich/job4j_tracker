package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Start go");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Count of passenger - " + count);
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 50;
    }
}
