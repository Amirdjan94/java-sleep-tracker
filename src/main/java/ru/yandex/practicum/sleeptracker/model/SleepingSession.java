package ru.yandex.practicum.sleeptracker.model;

import ru.yandex.practicum.sleeptracker.data.SleepQuality;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SleepingSession {
    private final LocalDateTime startSleep;
    private final LocalDateTime finishSleep;
    private final SleepQuality qualityOfSleep;

    DateTimeFormatter IN_LOG_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    @Override
    public String toString() {
        return "SleepingSession{" +
                "finishSlepp=" + finishSleep +
                ", startSleep=" + startSleep +
                ", qualityOfSleep=" + qualityOfSleep +
                ", IN_LOG_TIME_FORMAT=" + IN_LOG_TIME_FORMAT +
                '}';
    }

    public SleepingSession(String logNote) {
        String[] strArray = logNote.split(";");
        startSleep = LocalDateTime.parse(strArray[0], IN_LOG_TIME_FORMAT);
        finishSleep = LocalDateTime.parse(strArray[1], IN_LOG_TIME_FORMAT);
        qualityOfSleep = SleepQuality.valueOf(strArray[2]);
    }

    public LocalDateTime getFinishSleep() {
        return finishSleep;
    }

    public SleepQuality getQualityOfSleep() {
        return qualityOfSleep;
    }

    public LocalDateTime getStartSleep() {
        return startSleep;
    }
}