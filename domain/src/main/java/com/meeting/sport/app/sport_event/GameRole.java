package com.meeting.sport.app.sport_event;

public enum GameRole {
    BRAMKARZ,
    NAPASTNIK,
    ALLROLE;

    public static GameRole fromString(String value) {
        if (value != null) {
            value = value.trim().toUpperCase();
            switch (value) {
                case "BRAMKARZ" -> {
                    return BRAMKARZ;
                }
                case "NAPASTNIK" -> {
                    return NAPASTNIK;
                }
                case "ALLROLE" -> {
                    return ALLROLE;
                }
            }
        }
        throw new IllegalArgumentException("Invalid GameRole value: " + value);
    }

    @Override
    public String toString() {
        return "GameRole{}";
    }
}
