package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle aircraft1 = new Aircraft();
        Vehicle aircraft2 = new Aircraft();
        Vehicle aircraft3 = new Aircraft();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle train3 = new Train();
        Vehicle autobus1 = new Autobus();
        Vehicle autobus2 = new Autobus();
        Vehicle autobus3 = new Autobus();
        Vehicle[] vehicles = new Vehicle[]{
                aircraft1, aircraft2, aircraft3,
                train1, train2, train3,
                autobus1, autobus2, autobus3};
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + " " + vehicle);
            vehicle.move();
            System.out.println("Speed is " + vehicle.speed());
        }
    }
}
