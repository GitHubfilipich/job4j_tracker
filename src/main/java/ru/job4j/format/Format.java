package ru.job4j.format;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name) {
        System.out.println(String.format("Привет! Я %s", name));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreetingAndTime("Елена");
        System.out.println(String.format("Задаем число 0.99 - %08.3f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
    }
}
