package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalTime;
import java.time.Period;
import java.util.List;

public class SleeplessNightCount implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {
        long count = sleepingSessionList.stream()
                .filter(sleepingSession -> sleepingSession.getStartSleep() != null && sleepingSession.getFinishSleep() != null)
                .filter((sleepingSession) ->
                        (sleepingSession.getStartSleep().getDayOfYear() == sleepingSession.getFinishSleep().getDayOfYear() - 1) ||
                                (sleepingSession.getStartSleep().getHour() < 6)
                )
                .count();
        Period period = Period.between(
                        sleepingSessionList.getFirst().getStartSleep().toLocalDate(), sleepingSessionList.getLast().getFinishSleep().toLocalDate())
                .plusDays(1);

        if (sleepingSessionList.getFirst().getStartSleep().toLocalTime().isAfter(LocalTime.of(12, 0)))
            return Integer.toString(period.getDays() - (int) count);
        else return Integer.toString(period.getDays() - 1 - (int) count);
    }

}
