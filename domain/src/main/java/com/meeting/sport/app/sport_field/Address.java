package com.meeting.sport.app.sport_field;

public class Address {
    private final String city;
    private final String street;
    private final String number;

    Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    String getCity() {
        return city;
    }

    String getStreet() {
        return street;
    }

    String getNumber() {
        return number;
    }
}
