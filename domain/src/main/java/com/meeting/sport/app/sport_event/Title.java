package com.meeting.sport.app.sport_event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;


class Title {

    private final static int MAX_TITLE = 60;
    private final String value;

   public Title(String value) {
        this.value = checkTitle(value);
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

     public String getValue() {
        return value;
    }
}

