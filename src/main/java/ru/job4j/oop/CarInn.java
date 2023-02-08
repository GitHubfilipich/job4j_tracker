package ru.job4j.oop;

public class CarInn {
    private String brand;
    private String model;
    private static String carManual = "Инструкция к автомобилю";

    public CarInn(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public class Transmission {

        public void accelerate() {
            System.out.println("Ускорение");
        }

    }

    public class Brakes {

        public void brake() {
            System.out.println("Торможение");
        }

    }

    public class TripComputer {

        public String tripData = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Марка: " + brand);
            System.out.println("Модель: " + model);
            System.out.println("Модель TripComputer: " + this.model);
            System.out.println("Модель Car: " + CarInn.this.model);
        }

    }

    public static TripComputer getTripComputer() {
        CarInn car = new CarInn("Марка", "Модель");
        CarInn.TripComputer tripComputer = car.new TripComputer();
        return tripComputer;
    }

    public static class Manual {
        public String getManualNonStatic() {
            CarInn car = new CarInn("Марка", "Модель");
            return "Модель: " + car.model + ", Инструкция: " + carManual;
        }

        public static String getManual() {
            CarInn car = new CarInn("Марка", "Модель");
            return "Модель: " + car.model + ", Инструкция: " + carManual;
        }

    }
}
