package ru.job4j.testhm;

public class Catty extends Cat {
    @Override
    void miau() {
        System.out.println("Miau 2");
    }

    void sleep() {
        System.out.println("Sleep");
    }
}
