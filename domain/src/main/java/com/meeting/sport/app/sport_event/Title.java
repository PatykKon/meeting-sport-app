package com.meeting.sport.app.sport_event;

import lombok.Getter;


class Title {

    private final String title;
    private final static int MAX_TITLE = 60;

    Title(String title) {
        this.title = checkTitle(title);
    }

    private String checkTitle(String title) {
        if (title.length() > MAX_TITLE) {
            throw new RuntimeException("title is too long");
        }
        if (title.isEmpty() || title == null) {
            throw new RuntimeException("title can bo empty");
        }
        return title;
    }

    String getTitle() {
        return title;
    }
}

