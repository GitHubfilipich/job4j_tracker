package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @AfterEach
    public void clearData() {
        try (var tracker = new HbmTracker()) {
            var items = tracker.findAll();
            items.forEach(item -> tracker.delete(item.getId()));
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenTrackerHasChangedItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            Item itemNew = new Item("test2");

            var result = tracker.replace(item.getId(), itemNew);
            var itemResult = tracker.findById(item.getId());

            assertThat(result).isTrue();
            assertThat(itemResult.getName()).isEqualTo(itemNew.getName());
        }
    }

    @Test
    public void whenDeleteItemThenTrackerHasNoDeletedItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);

            tracker.delete(item.getId());
            var result = tracker.findById(item.getId());

            assertThat(result).isNull();
        }
    }

    @Test
    public void whenFindAllThenTrackerHasAllItems() {
        try (var tracker = new HbmTracker()) {
            var items = List.of(new Item("test1"), new Item("test2"), new Item("test3"));
            items.forEach(tracker::add);

            var result = tracker.findAll();

            assertThat(result.stream().map(Item::getName).toList()).
                    containsExactlyInAnyOrderElementsOf(items.stream().map(Item::getName).toList());
        }
    }

    @Test
    public void whenFindByNameThenTrackerHasItemsWithName() {
        try (var tracker = new HbmTracker()) {
            var searchName = "name";
            var items = List.of(new Item("test1" + searchName), new Item("test2" + searchName), new Item("test3"));
            items.forEach(tracker::add);

            var result = tracker.findByName(searchName);

            assertThat(result.stream().map(Item::getName).toList()).
                    containsExactlyInAnyOrderElementsOf(List.of(items.get(0).getName(), items.get(1).getName()));
        }
    }

    @Test
    public void whenFindByIdThenTrackerHasItemWithId() {
        try (var tracker = new HbmTracker()) {
            var items = List.of(new Item("test1"), new Item("test2"), new Item("test3"));
            items.forEach(tracker::add);
            var searchedItem = items.get(1);

            var result = tracker.findById(searchedItem.getId());

            assertThat(result).isNotNull();
            assertThat(result.getName()).isEqualTo(searchedItem.getName());
        }
    }
}
