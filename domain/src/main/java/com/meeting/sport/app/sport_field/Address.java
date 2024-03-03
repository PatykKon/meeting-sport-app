package com.meeting.sport.app.sport_field;

import lombok.Getter;

@Getter
public class Address {
    String city;
    String street;
    String number;

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }
}
