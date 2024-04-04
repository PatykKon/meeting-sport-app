package com.meeting.sport.app.sport_event;

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
            throw new RuntimeException("title can not bo empty");
        }
        return title;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(value, title.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

