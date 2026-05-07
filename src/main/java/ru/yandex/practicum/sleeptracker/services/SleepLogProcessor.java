package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;

@FunctionalInterface
public interface SleepLogProcessor {
    String doProcess(List<SleepingSession> sleepingSessionList);
}
