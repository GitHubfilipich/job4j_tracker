package ru.job4j.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("first");
        queue.offer("second");
        queue.offer("third");
        queue.offer("fourth");

        for (String string : queue) {
            System.out.println(string);
        }
    }
}
