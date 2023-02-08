package ru.job4j.oop;

public class CarMain {

    public static void main(String[] args) {
        CarInn car = new CarInn("Марка", "Модель");
        CarInn.Transmission transmission = car.new Transmission();
        CarInn.Brakes brakes = car.new Brakes();
        car.startEngine();
        transmission.accelerate();
        brakes.brake();
        CarInn.TripComputer tripComputer = car.new TripComputer();
        tripComputer.getInfo();
        CarInn.Manual manual = new CarInn.Manual();
        System.out.println("Non static: " + manual.getManualNonStatic());
        System.out.println("Static: " + CarInn.Manual.getManual());
    }
}
