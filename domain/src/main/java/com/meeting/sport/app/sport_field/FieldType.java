package com.meeting.sport.app.sport_field;

enum FieldType {
    FOOTBALL("football"),
    BASKETBALL("basketball"),
    VOLLEYBALL("volleyball"),
    TENNIS("tennis"),
    SQUASH("squash");

    private final String fieldType;


    FieldType(String filedType) {
        this.fieldType = filedType;

    }

    @Override
    public String toString() {
        return fieldType;
    }
}
