package com.meeting.sport.app.sport_event;

import lombok.Getter;

@Getter
class Description {
    private final String description;

    private final static int MAX_DESCRIPTION = 250;

    public Description(String description) {
        this.description = checkDescription(description);
    }

    private String checkDescription(String title) {
        if (title.length() > MAX_DESCRIPTION) {
            throw new RuntimeException("description is too long");
        }
        if (title.isEmpty() || title == null) {
            throw new RuntimeException("description can bo empty");
        }
        return title;
    }

}
