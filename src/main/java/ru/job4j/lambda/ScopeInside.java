package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ScopeInside {
    private static String first = "Гав";
    private static String second = "Муу";

    public static void main(String[] args) {
        String ayyyy = "ayyyyy";
        ayyyy = "aaaaa";
        String tmp = ayyyy;
        String name = echo(
                () -> {
                    return tmp;
                }
        );
        System.out.println(name);

        String test = echo(
                () -> {
                    second = "Мяу";
                    return first + second;
                }
        );
        System.out.println(test);
        System.out.println(second);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(throwingExceptionConsumerWrapper(n -> methodThrowingAnException(n)));
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }

    static void methodThrowingAnException(Integer integer) throws Exception {
        throw new Exception("methodThrowingAnException");
    }

    @FunctionalInterface
    public interface ThrowingExceptionConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }

    static <T> Consumer<T> throwingExceptionConsumerWrapper(
            ThrowingExceptionConsumer<T, Exception> throwingExceptionConsumer) {
        return x -> {
            try {
                throwingExceptionConsumer.accept(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}