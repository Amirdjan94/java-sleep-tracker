package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.UserTypeDefenition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTypeDefenitionTest {

    UserTypeDefenition userTypeDefenition = new UserTypeDefenition();

    @Test
    public void doProcessMultipleSessionsOnlyOwlGetOwlTypeUser() {
        assertEquals("Сова", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:10;02.10.25 10:00;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 10:10;NORMAL"),
                        new SleepingSession("03.10.25 23:50;04.10.25 10:10;NORMAL"))));
    }

    @Test
    public void doProcessMultipleSessionsOnlyLarkGetLarkTypeUser() {
        assertEquals("Жаворонок", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 21:00;02.10.25 05:00;GOOD"),
                        new SleepingSession("02.10.25 21:50;03.10.25 06:10;NORMAL"),
                        new SleepingSession("03.10.25 21:50;04.10.25 06:10;NORMAL"))));
    }

    @Test
    public void doProcessMultipleSessionsOnlyDoveGetDoveTypeUser() {
        assertEquals("Голубь", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 21:00;02.10.25 09:10;GOOD"),
                        new SleepingSession("02.10.25 21:50;03.10.25 09:15;NORMAL"),
                        new SleepingSession("03.10.25 21:50;04.10.25 09:20;NORMAL"))));
    }

    @Test
    public void doProcessSingleSessionsOnlyOwlGetOwlTypeUser() {
        assertEquals("Сова", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:10;02.10.25 10:00;GOOD"))));
    }

    @Test
    public void doProcessSingleSessionsOnlyLarkGetLarkTypeUser() {
        assertEquals("Жаворонок", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 21:00;02.10.25 05:00;GOOD"))));
    }

    @Test
    public void doProcessSingleSessionsOnlyDoveGetDoveTypeUser() {
        assertEquals("Голубь", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 21:00;02.10.25 09:10;GOOD"))));
    }

    @Test
    public void doProcessMultipleSessionsWithMultipleUserTypeGetOwlTypeUser() {
        assertEquals("Сова", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 21:00;02.10.25 05:00;GOOD"),
                        new SleepingSession("02.10.25 21:00;03.10.25 09:10;GOOD"),
                        new SleepingSession("03.10.25 23:10;04.10.25 10:00;GOOD"),
                        new SleepingSession("04.10.25 23:50;05.10.25 10:10;NORMAL"),
                        new SleepingSession("05.10.25 23:50;06.10.25 10:10;NORMAL"))));
    }

    @Test
    public void doProcessMultipleSessionsWithMultipleUserTypeGetLarkTypeUser() {
        assertEquals("Жаворонок", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:10;02.10.25 10:00;GOOD"),
                        new SleepingSession("02.10.25 21:00;03.10.25 09:10;GOOD"),
                        new SleepingSession("03.10.25 21:00;04.10.25 05:00;GOOD"),
                        new SleepingSession("04.10.25 21:50;05.10.25 06:10;NORMAL"),
                        new SleepingSession("05.10.25 21:50;06.10.25 06:10;NORMAL"))));
    }

    @Test
    public void doProcessMultipleSessionsWithMultipleUserTypeGetDoveTypeUser() {
        assertEquals("Голубь", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:50;02.10.25 10:10;NORMAL"),
                        new SleepingSession("02.10.25 21:50;03.10.25 06:10;NORMAL"),
                        new SleepingSession("03.10.25 21:00;04.10.25 09:10;GOOD"),
                        new SleepingSession("04.10.25 21:50;05.10.25 09:15;NORMAL"),
                        new SleepingSession("05.10.25 21:50;06.10.25 09:20;NORMAL"))));
    }

    @Test
    public void doProcessMultipleSessionsWithSleeplessSessionsGetOwlTypeUser() {
        assertEquals("Сова", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:10;02.10.25 10:00;GOOD"),
                        new SleepingSession("02.10.25 23:50;03.10.25 10:10;NORMAL"),
                        new SleepingSession("03.10.25 23:50;04.10.25 10:10;NORMAL"),
                        new SleepingSession("04.10.25 15:30;04.10.25 16:00;NORMAL"),
                        new SleepingSession("05.10.25 15:30;05.10.25 16:00;NORMAL"),
                        new SleepingSession("06.10.25 15:30;06.10.25 16:00;NORMAL"),
                        new SleepingSession("07.10.25 15:30;07.10.25 16:00;NORMAL"))));
    }

    @Test
    public void doProcessSessionsWithLarkEqualSessionWithOwlGetDoveTypeUser() {
        assertEquals("Голубь", userTypeDefenition.doProcess(
                List.of(new SleepingSession("01.10.25 23:10;02.10.25 10:00;GOOD"),
                        new SleepingSession("01.10.25 21:00;02.10.25 05:00;GOOD")
                )));
    }

}
