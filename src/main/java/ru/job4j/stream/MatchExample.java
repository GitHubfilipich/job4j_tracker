package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean rsl = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(rsl);

        boolean rsl1 = strings
                .stream()
                .anyMatch(e -> e.endsWith("ь"));
        System.out.println(rsl1);

        List<String> strings1 = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean rsl2 = strings1
                .stream()
                .allMatch(e -> e.startsWith("Три"));
        System.out.println(rsl2);
    }
}
