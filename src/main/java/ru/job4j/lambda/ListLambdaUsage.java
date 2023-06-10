package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

public class ListLambdaUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 7, 9, 12);

        list.forEach(s -> System.out.println("Current number: " + s));

        list.replaceAll(i -> i * i);

        list.forEach(s -> System.out.println("Current number: " + s));
    }
}
