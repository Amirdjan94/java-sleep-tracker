package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.Duration;
import java.util.List;

public class AvgSleepSession implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {
        return Integer.toString((sleepingSessionList.stream()
                .map((element) -> Duration.between(element.getStartSleep(), element.getFinishSleep()))
                .map(element -> (int) element.toMinutes())
                .reduce((accumulator, element)->accumulator+element)
                        ).get()/sleepingSessionList.size());
    }
}
