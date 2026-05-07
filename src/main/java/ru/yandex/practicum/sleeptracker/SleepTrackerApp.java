package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.exceptions.IncorrectArgumentException;
import ru.yandex.practicum.sleeptracker.exceptions.NoArgumentExcpetion;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SleepTrackerApp {

    public static List<SleepingSession> sleepingSessionsList = new ArrayList<>();

    private static SleepAnalysisResult sleepAnalysisResult = new SleepAnalysisResult();

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new NoArgumentExcpetion("Отсуствует параметр для запуска системы. Укажите путь до лог файла");
        } else if (args.length > 1) {
            throw new IncorrectArgumentException("Не корректные входные данные: Укажите путь только для одного лог файла");
        }
        String path = args[0];
        SleepTrackerApp sleepTrackerApp = new SleepTrackerApp();
        sleepTrackerApp.readSleepLog(path); // Чтение лога из файла
        sleepTrackerApp.addProcessInAnalys(); // Инициализация функций
        sleepAnalysisResult.lineProcess(); // Запуск функций
    }

    private void addProcessInAnalys() {
        sleepAnalysisResult.addProcess("Количество сессий сна за предоставленный период - ", new CountSleepSession());
        sleepAnalysisResult.addProcess("Минимальная продолжительность сессии (в минутах) - ", new MinDurationInSession());
        sleepAnalysisResult.addProcess("Средняя продолжительность сессии (в минутах) - ", new AvgSleepSession());
        sleepAnalysisResult.addProcess("Количество сессий с плохим качеством сна - ", new CountBadSleepSession());
        sleepAnalysisResult.addProcess("Количество бессонных ночей - ", new SleeplessNightCount());
        sleepAnalysisResult.addProcess("Пользователь относиться к типу - ", new UserTypeDefenition());
    }

    private void readSleepLog(String pathSleepLog) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathSleepLog))) {
            Stream<String> lines = br.lines();
            sleepingSessionsList = lines.map(element -> new SleepingSession(element)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}