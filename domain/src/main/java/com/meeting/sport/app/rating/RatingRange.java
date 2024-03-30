package com.meeting.sport.app.rating;

enum RatingRange {
    NEW_GAMER("New gamer"),
    NEUTRAL("Neutral"),
    GOOD_PLAYER("Good player"),
    THE_BEST_PLAYER("The Best Player");

    private final String type;

    RatingRange(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
