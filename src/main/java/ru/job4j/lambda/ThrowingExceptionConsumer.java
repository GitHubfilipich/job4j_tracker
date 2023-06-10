package ru.job4j.lambda;

@FunctionalInterface
public interface ThrowingExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}
