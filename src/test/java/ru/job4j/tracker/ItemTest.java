package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenItemsSortedAscending() {
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemC = new Item("C");
        List<Item> items = Arrays.asList(itemB, itemC, itemA);
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(itemA, itemB, itemC);
        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenItemsSortedDescending() {
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemC = new Item("C");
        List<Item> items = Arrays.asList(itemB, itemC, itemA);
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(itemC, itemB, itemA);
        assertThat(items).containsExactlyElementsOf(expected);
    }

}