package ru.job4j.autopack;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }

    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = a;
        System.out.printf("Integer b = %s\n", b);
        int x = 2;
        num(x);
        Integer m = 3;
        int n = m;
        System.out.println("int n = " + n);
        Integer k = 5;
        Integer l = 6;
        System.out.println(k * l);
        Integer g = 250;
        Integer h = 250;
        System.out.printf("g == h -> %s\n", g == h);
        System.out.printf("(int) g == (int) h -> %s\n", (int) g == (int) h);
        Integer v = 127;
        Integer w = 127;
        System.out.printf("v == w -> %s\n", v == w);
        Integer sum = 0;
        for (int i = 128; i < 300; i++) {
            sum += i;
        }
        System.out.println(sum);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
}
