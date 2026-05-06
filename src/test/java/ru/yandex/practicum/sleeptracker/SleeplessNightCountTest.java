package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.SleeplessNightCount;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SleeplessNightCountTest {
    SleeplessNightCount sleeplessNightCount = new SleeplessNightCount();

    @Test
    public void doProcessMultipleSessionGetOneSleeplessSessionTest() {
        assertEquals("2", sleeplessNightCount.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;01.10.25 23:10;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 00:10;NORMAL"),
                        new SleepingSession("03.10.25 23:50;04.10.25 00:10;NORMAL"))));
    }

    @Test
    public void doProcessSingleSessionGetOneSleeplessSessionTest() {
        assertEquals("1", sleeplessNightCount.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;01.10.25 23:10;GOOD"))));
    }

    @Test
    public void doProcessMultipleSessionGetTwoSleeplessSessionTest() {
        assertEquals("3", sleeplessNightCount.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;01.10.25 23:10;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 00:10;NORMAL"),
                        new SleepingSession("03.10.25 23:50;04.10.25 00:10;NORMAL"),
                        new SleepingSession("05.10.25 23:00;05.10.25 23:10;GOOD"))));
    }
}
