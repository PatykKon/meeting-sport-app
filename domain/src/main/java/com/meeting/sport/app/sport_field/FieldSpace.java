package com.meeting.sport.app.sport_field;

enum FieldSpace {
    INSIDE("inside"),
    OUTSIDE("outside");

    private final String fieldSpace;

    FieldSpace(String fieldSpace) {
        this.fieldSpace = fieldSpace;
    }

    @Override
    public String toString() {
        return fieldSpace;
    }
}
