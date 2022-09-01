package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public void show() {
        System.out.println("name = " + this.name + ", food = " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        Cat sparky = new Cat();
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("gav");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("black");
        black.show();
    }
}
