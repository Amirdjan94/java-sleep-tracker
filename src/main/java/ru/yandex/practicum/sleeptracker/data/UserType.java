package ru.yandex.practicum.sleeptracker.data;

public enum UserType {
    OWL("Сова"), // Сова
    LARK("Жаворонок"),// Жаворонок
    DOVE("Голубь");//

    private String userSleepingType;

    UserType(String userSleepingType) {
        this.userSleepingType = userSleepingType;
    }

    public String getuserSleepingType() {
        return userSleepingType;
    }
}
