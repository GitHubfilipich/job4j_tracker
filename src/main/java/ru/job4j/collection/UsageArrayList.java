package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Petr");
        strings.add("Ivan");
        strings.add("Stepan");
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
