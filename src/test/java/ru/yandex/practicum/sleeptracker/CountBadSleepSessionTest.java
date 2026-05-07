package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.CountBadSleepSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CountBadSleepSessionTest {

    CountBadSleepSession countBadSleepSession = new CountBadSleepSession();

    @Test
    public void doProcessSingleBadSessionGetCountBadSession() {
        assertEquals("1", countBadSleepSession.doProcess(List.of(
                new SleepingSession("03.10.25 23:40;04.10.25 08:00;BAD"))));
    }

    @Test
    public void doProcessMultipleBadSessionGetCountBadSession() {
        assertEquals("2", countBadSleepSession.doProcess(List.of(
                new SleepingSession("03.10.25 23:40;04.10.25 08:00;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 00:10;BAD")
        )));
    }

    @Test
    public void doProcessMultipleSessionGetCountBadSession() {
        assertEquals("2", countBadSleepSession.doProcess(List.of(
                new SleepingSession("03.10.25 23:40;04.10.25 08:00;BAD"),
                new SleepingSession("02.10.25 23:50;03.10.25 00:10;GOOD"),
                new SleepingSession("03.10.25 23:50;04.10.25 00:10;BAD")
        )));
    }

    @Test
    public void doProcessMultipleSessionWithoutBadSessionGetCountBadSession() {
        assertEquals("0", countBadSleepSession.doProcess(List.of(
                new SleepingSession("02.10.25 23:50;03.10.25 00:10;GOOD"),
                new SleepingSession("03.10.25 23:50;04.10.25 00:10;GOOD")
        )));
    }

}