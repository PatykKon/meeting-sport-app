package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.exceptions.TeamValidationException;

class Team {

    private final static int MIN_PLAYERS_IN_GAME = 2;
    private final static int MAX_PLAYERS_IN_GAME = 100;

    private int teamSize;
    private int minPlayers;

    private Team(){

    }

    Team(Integer teamSize, Integer minPlayers) {
        this.teamSize = checkMaxPlayer(teamSize);
        this.minPlayers = checkMinPlayers(minPlayers, teamSize);
    }

    private int checkMinPlayers(int minPlayers, int teamSize) {
        if (minPlayers > teamSize) {
            throw new TeamValidationException("min players can no be more than teamSize");
        }
        if (minPlayers < MIN_PLAYERS_IN_GAME) {
            throw new TeamValidationException("2 is minimum players");
        }
        return minPlayers;
    }

    private int checkMaxPlayer(int players) {
        if (players > MAX_PLAYERS_IN_GAME) {
            throw new TeamValidationException("is too many players ");
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
