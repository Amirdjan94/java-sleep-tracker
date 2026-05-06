package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.MinDurationInSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDurationInSessionTest {

    MinDurationInSession minDurationInSession = new MinDurationInSession();

    @Test
    public void doProcessMultipleSessionsGetMinDurationInSessionTest() {
        assertEquals("20", minDurationInSession.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;02.10.25 00:00;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 00:10;NORMAL"))));
    }

    @Test
    public void doProcessSingleSessionsGetMinDurationInSessionTest() {
        assertEquals("60", minDurationInSession.doProcess(
                List.of(new SleepingSession("01.10.25 23:00;02.10.25 00:00;GOOD"))));
    }
}
