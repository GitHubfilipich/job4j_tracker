package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionLambdaUsage {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("name");
        collection.add("top");
        collection.add("user");
        collection.add("precision");
        collection.add("post");

        collection.forEach(System.out::println);

        collection.removeIf(s -> s.length() == 4);

        collection.forEach(System.out::println);
    }
}
