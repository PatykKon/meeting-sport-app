package com.meeting.sport.app.sport_field;

public class SportField {

    private Long id;
    private FieldType fieldType;
    private FieldSpace fieldSpace;
    private Address address;

    public SportField(Long id, FieldType fieldType, FieldSpace fieldSpace, Address address) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
        this.address = address;
    }

    static SportField createSportField(String fieldType, String fieldSpace, String city, String street, String number) {
        Address fieldAddress = new Address(city, street, number);

        return new SportField(null, FieldType.valueOf(fieldType), FieldSpace.valueOf(fieldSpace), fieldAddress);
    }

    Long getId() {
        return id;
    }

    FieldType getFieldType() {
        return fieldType;
    }

    FieldSpace getFieldSpace() {
        return fieldSpace;
    }

    Address getAddress() {
        return address;
    }

}

