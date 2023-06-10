package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class RefMethodExmpl {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr"
        );
        Consumer<String> consumer = (name) -> System.out.println(name);
        names.forEach(consumer);
        Consumer<String> consumer2 = System.out::println;
        names.forEach(consumer2);

        List<Integer> digits = Arrays.asList(
                10,
                5
        );
        Comparator<Integer> intCmp = (left, right) -> Integer.compare(right, left);
        digits.sort(intCmp);
        Consumer<Integer> consumer3 = System.out::println;
        digits.forEach(consumer3);

        Comparator<Integer> intCmp2 = Integer::compare;
        digits.sort(intCmp2);
        digits.forEach(consumer3);

    }
}
