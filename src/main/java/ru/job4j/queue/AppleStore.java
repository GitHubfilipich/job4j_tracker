package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String name = null;
        int size = queue.size();
        for (int i = 0; i < count && i < size; i++) {
            Customer customer = queue.poll();
            name = customer.name();
        }
        return name;
    }

    public String getFirstUpsetCustomer() {
        Customer customer = null;
        for (int i = 0; i <= count; i++) {
            customer = queue.poll();
        }
        return customer != null ? customer.name() : null;
    }
}
