package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arrayO1 = o1.split("/");
        String[] arrayO2 = o2.split("/");
        for (int i = 0; i < Math.min(arrayO1.length, arrayO2.length); i++) {
            if (!arrayO1[i].equals(arrayO2[i])) {
                return i == 0 ? arrayO2[i].compareTo(arrayO1[i]) : arrayO1[i].compareTo(arrayO2[i]);
            }
        }
        return Integer.compare(arrayO1.length, arrayO2.length);
    }
}
