package ru.yandex.practicum.sleeptracker.services;

import java.util.HashMap;

import static ru.yandex.practicum.sleeptracker.SleepTrackerApp.sleepingSessionsList;

public class SleepAnalysisResult {
    HashMap<String, SleepLogProcessor> lineProcessor = new HashMap<>();

    public void addProcess(String processorName, SleepLogProcessor process) {
        lineProcessor.put(processorName, process);
    }

    public void lineProcess() { // Выполнение функций
        for (String processorName : lineProcessor.keySet()) {
            System.out.println(
                    processorName + lineProcessor.get(processorName).doProcess(sleepingSessionsList)
            );
        }
    }
}

