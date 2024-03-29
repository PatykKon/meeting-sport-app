package com.meeting.sport.app.sport_event;

class Description {

    private final static int MAX_DESCRIPTION = 250;
    private final String value;

    public Description(String value) {
        this.value = checkDescription(value);
    }

    private String checkDescription(String description) {
        if (description.length() > MAX_DESCRIPTION) {
            throw new RuntimeException("description is too long");
        }
        if (description.isEmpty() || description == null) {
            throw new RuntimeException("description can bo empty");
        }
        return description;
    }
    public String getValue() {
        return value;
    }
}
