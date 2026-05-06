package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;

public class CountSleepSession implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {
        return Long.toString(sleepingSessionList.stream().count());
    }
}
