package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int calcResult;
        if (n == 0 || n == 1) {
            calcResult = 1;
        } else {
            calcResult = calc(n - 1) * n;
        }
        return calcResult;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
