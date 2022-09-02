package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
    }
}
