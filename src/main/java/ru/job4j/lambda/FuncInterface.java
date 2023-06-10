package ru.job4j.lambda;

public interface FuncInterface {
    Model function(String s);

    default Model functionEmpty() {
        return new Model();
    }
}
