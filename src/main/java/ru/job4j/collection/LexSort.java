package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftNumber, rightNumber;
        try {
            leftNumber = Integer.parseInt(left.split("\\.")[0]);
        } catch (Exception e) {
            leftNumber = 0;
        }
        try {
            rightNumber = Integer.parseInt(right.split("\\.")[0]);
        } catch (Exception e) {
            rightNumber = 0;
        }
        return Integer.compare(leftNumber, rightNumber);
    }
}
