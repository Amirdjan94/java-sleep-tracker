package ru.yandex.practicum.sleeptracker.services;

import ru.yandex.practicum.sleeptracker.data.UserType;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserTypeDefenition implements SleepLogProcessor {
    @Override
    public String doProcess(List<SleepingSession> sleepingSessionList) {

        // Фильтруем ночные сессии сна и Сопоставляем каждую ночную сессию сна с типом пользователя
        List<UserType> userTypeList = sleepingSessionList.stream()
                .filter(sleepingSession -> sleepingSession.getStartSleep() != null && sleepingSession.getFinishSleep() != null)
                .filter((sleepingSession) ->
                        (sleepingSession.getStartSleep().getDayOfYear() == sleepingSession.getFinishSleep().getDayOfYear() - 1) ||
                                (sleepingSession.getStartSleep().getHour() < 6)
                )
                .map((sleepingSession) -> {
                    if (sleepingSession.getStartSleep().toLocalTime().isAfter(LocalTime.of(23, 0)) &&
                            sleepingSession.getFinishSleep().toLocalTime().isAfter(LocalTime.of(9, 0))) { //«Сова» — если время засыпания было после 23:00, а время пробуждения — после 9:00.
                        return UserType.OWL;
                    } else if (sleepingSession.getStartSleep().toLocalTime().isBefore(LocalTime.of(22, 0)) &&
                            sleepingSession.getFinishSleep().toLocalTime().isBefore(LocalTime.of(7, 0))) { //«Жаворонок» — если время засыпания было до 22:00, а время пробуждения до — 7:00.
                        return UserType.LARK;
                    } else {
                        return UserType.DOVE;
                    } //«Голубь» — во всех остальных случаях.
                })
                .collect(Collectors.toList());

        // Подсчет количесв количества каждого вида сна
        long owlCount = userTypeList.stream().filter((element) -> element == UserType.OWL).count();
        long larkCount = userTypeList.stream().filter((element) -> element == UserType.LARK).count();
        long doveCount = userTypeList.stream().filter((element) -> element == UserType.DOVE).count();

        if (owlCount > larkCount && owlCount > doveCount) return UserType.OWL.getuserSleepingType();
        else if (larkCount > owlCount && larkCount > doveCount) return UserType.LARK.getuserSleepingType();
        else return UserType.DOVE.getuserSleepingType();
    }
}
