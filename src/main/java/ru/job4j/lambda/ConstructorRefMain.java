package ru.job4j.lambda;

import java.util.Arrays;

public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Example");
        System.out.println("Значение равно: " + model.getName());

        model = modelConstructor.functionEmpty();
        System.out.println("Значение равно: " + model.getName());

        FuncInterfaceEmpty funcInterfaceEmpty = Model::new;
        Model model2 = funcInterfaceEmpty.functionModel();
        System.out.println("Значение равно: " + model.getName());

        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, (a, b) -> a.compareTo(b));
        for (String s : stringArray) {
            System.out.println(s);
        }

        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String s : stringArray) {
            System.out.println(s);
        }
    }
}
