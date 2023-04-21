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
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            if (customer == null) {
                break;
            }
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
