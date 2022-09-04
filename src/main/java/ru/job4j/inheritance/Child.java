package ru.job4j.inheritance;

public class Child extends Parent {
    private String patronymic;

    public Child(String name, int age, String patronymic) {
        super(name, age);
        this.patronymic = patronymic;
    }
}
