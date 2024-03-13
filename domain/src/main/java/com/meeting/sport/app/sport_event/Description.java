package com.meeting.sport.app.sport_event;

class Description {

    private final static int MAX_DESCRIPTION = 250;
    private final String value;

    public Description(String value) {
        this.value = checkDescription(value);
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
    public String getValue() {
        return value;
    }
}
