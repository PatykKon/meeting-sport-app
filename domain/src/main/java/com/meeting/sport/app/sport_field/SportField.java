package com.meeting.sport.app.sport_field;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SportField {

    private final Long id;
    private FieldType fieldType;
    private FieldSpace fieldSpace;
    private Address address;


    private SportField(Long id,FieldType fieldType, FieldSpace fieldSpace,Address address) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
        this.address = address;
    }

    public static SportField addSportField(FieldType fieldType, FieldSpace fieldSpace,String city,String street, String number){
        Address fieldAddress = new Address(city,street,number);

        return new SportField(builder().id, fieldType,fieldSpace,fieldAddress);
    }
}

