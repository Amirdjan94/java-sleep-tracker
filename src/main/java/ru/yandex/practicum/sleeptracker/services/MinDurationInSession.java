package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.Duration;
import java.util.List;

public class MinDurationInSession implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {
        return Long.toString((sleepingSessionList.stream()
                .map((element) -> Duration.between(element.getStartSleep(), element.getFinishSleep()))
                .min((o1, o2) -> o1.compareTo(o2))
        ).get().toMinutes());
    }
}
