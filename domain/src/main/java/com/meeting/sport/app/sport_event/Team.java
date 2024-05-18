package com.meeting.sport.app.sport_event;

class Team {

    private final static int MIN_PLAYERS_IN_GAME = 2;
    private final static int MAX_PLAYERS_IN_GAME = 100;

    private final int teamSize;
    private final int minPlayers;

    Team(int teamSize, int minPlayers) {
        this.teamSize = checkMaxPlayer(teamSize);
        this.minPlayers = checkMinPlayers(minPlayers, teamSize);
    }

    private int checkMinPlayers(int minPlayers, int teamSize) {
        if (minPlayers > teamSize) {
            throw new RuntimeException("min players can no be more than teamSize");
        }
        if (minPlayers < MIN_PLAYERS_IN_GAME) {
            throw new RuntimeException("2 is minimum players");
        }
        return minPlayers;
    }

    private int checkMaxPlayer(int players) {
        if (players > MAX_PLAYERS_IN_GAME) {
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
