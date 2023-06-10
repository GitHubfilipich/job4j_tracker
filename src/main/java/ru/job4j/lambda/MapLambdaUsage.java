package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        map.replaceAll((key, value) -> value + "_" + key);

        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "name");

        String result = map1.computeIfPresent(1, (key, value) -> value + "_" + key);

        System.out.println("Current value: " + result);
        map1.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Petr", 5);

        map3.computeIfAbsent("Petr", String::length);
        map3.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Shoes", 200);

        int newPrice = map4.merge("Shoes", 50, (oldValue, newValue) -> oldValue - newValue);
        System.out.println("New price: " + newPrice);

        map4.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
