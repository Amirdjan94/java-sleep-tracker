package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.data.SleepQuality;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;

public class CountBadSleepSession implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {
        return Long.toString(sleepingSessionList.stream()
                .filter(sleepingSession -> sleepingSession.getStartSleep() != null && sleepingSession.getFinishSleep() != null)
                .filter((element) -> element.getQualityOfSleep() == SleepQuality.BAD).count());
    }
}
