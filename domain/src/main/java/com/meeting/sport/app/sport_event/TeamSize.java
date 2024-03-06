package com.meeting.sport.app.sport_event;

import lombok.Value;

class TeamSize {

    private final int teamSize;

    TeamSize(int teamSize) {
        this.teamSize = checkMaxPlayer(teamSize);
    }

    private int checkMaxPlayer(int players) {
        if (players > 100) {
            throw new RuntimeException("is too many players ");
        }
        if (players <= 1) {
            throw new RuntimeException("2 is minimum players");
        }
        return players;
    }

    public int getTeamSize() {
        return teamSize;
    }

}
