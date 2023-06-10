package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StrategyUsage {
    public boolean empty(String s) {
        return check(str -> str.isEmpty(), s);
    }

    public boolean startWith(String s, String pref) {
        return check(str -> str.startsWith(pref), s);
    }

    public boolean contains(String s, String key) {
        return check(str -> str.contains(key), s);
    }

    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.isEmpty(), ""
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.startsWith("Fun"), "Functional interface"
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.contains("rn"), "Surname Name"
                )
        );

        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        str -> str.toUpperCase(), "aBCdEfghKLmnpRstU"
                )
        );
        System.out.println(
                usage.transform(
                        str -> str.concat("работает корректно."), "Строка после преобразования: "
                )
        );
        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        str -> str.trim(), "    aBC dEfghK Lmnp RstU        "
                )
        );

        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);

        String[] names2 = {
                "Ivan",
                "Petr"
        };
        Arrays.sort(names2, lengthCmp);
    }
}
