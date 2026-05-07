package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.AvgSleepSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvgSleepSessionTest {
    AvgSleepSession avgSleepSession = new AvgSleepSession();

    @Test
    public void doProcessMultipleSessionsGetAvgSessionTest() {
        assertEquals("40", avgSleepSession.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;02.10.25 00:00;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 00:10;NORMAL"))));
    }

    @Test
    public void doProcessSingleSessionsGetAvgSessionTest() {
        assertEquals("60", avgSleepSession.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;02.10.25 00:00;GOOD"))));
    }
}
