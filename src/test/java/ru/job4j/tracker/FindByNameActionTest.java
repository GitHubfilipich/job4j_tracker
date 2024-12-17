package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenItemWasFoundSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item(1, "New item",
                LocalDateTime.of(2024, 12, 17, 0, 0, 0)));
        FindByNameAction action = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Item{id=1, name='New item', created=17-декабря-вторник-2024 00:00:00}" + ln
        );
    }

    @Test
    public void whenItemWasNotFoundSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByNameAction action = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: New item не найдены." + ln
        );
    }
}