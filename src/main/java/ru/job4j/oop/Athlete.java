package ru.job4j.oop;

public class Athlete extends Sportsman {

    @Override
    void run() {
        System.out.println("Быстрая скорость бега");
    }

    public void sprint() {
        System.out.println("Быстрый рывок на короткую дистанцию");
    }
}
