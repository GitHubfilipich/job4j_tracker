package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Card> cards = Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values()).map(v -> new Card(s, v)))
                .collect(Collectors.toList());

        cards.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}
