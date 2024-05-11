package com.meeting.sport.app.sport_event;

enum GameRole {
    BRAMKARZ("Bramkarz"),
    NAPASTNIK("Napastnik");

    private final String roleDescription;

    GameRole(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return roleDescription;
    }
}
