package ru.job4j.concat;

public class JoinExample {
    public static void main(String[] args) {
        String[] sa = {"abc", "def", "ghi"};
        String str = String.join(" ", sa);
        System.out.println(str);
    }
}
