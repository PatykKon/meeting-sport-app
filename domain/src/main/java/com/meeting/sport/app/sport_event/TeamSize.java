package com.meeting.sport.app.sport_event;

import lombok.Value;

class TeamSize {

    private final int teamSize;
    private final int minPlayers;

    TeamSize(int teamSize, int minPlayers) {
        this.teamSize = checkMaxPlayer(teamSize);
        this.minPlayers = checkMinPlayers(minPlayers, teamSize);
    }

    private int checkMinPlayers(int minPlayers, int teamSize) {
        if (minPlayers > teamSize) {
            throw new RuntimeException("min players can no be more than teamSize");
        }
        if (minPlayers < 2) {
            throw new RuntimeException("2 is minimum players");
        }
        return minPlayers;
    }

    private int checkMaxPlayer(int players) {
        if (players > 100) {
            throw new RuntimeException("is too many players ");
        }
        return players;
    }

    int getTeamSize() {
        return teamSize;
    }

    int getMinPlayers() {
        return minPlayers;
    }
}
