package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.*;

public class SumExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);

        List.of(5, 1, 2).forEach(System.out::print);

        Set.of(5, 1, 2).forEach(System.out::print);

        Map.of("first", 1, "second", 2)
                .forEach((v, k) -> System.out.println(v + " " + k));

        List<Integer> expect = Arrays.asList(1, 2, 3);
        expect.set(0, 22);
        expect.forEach(System.out::println);

        List<Integer> expect1 = List.of(1, 2, 3);
        expect.forEach(System.out::println);
    }
}
