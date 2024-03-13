package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEvent;
import java.util.List;

public class SportField {

    private Long id;
    private FieldType fieldType;
    private FieldSpace fieldSpace;
    private Address address;
    private List<SportEvent> sportEvents;

    public SportField(Long id, FieldType fieldType, FieldSpace fieldSpace, Address address, List<SportEvent> sportEvents) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
        this.address = address;
        this.sportEvents = sportEvents;
    }

    public static SportField addSportField(FieldType fieldType, FieldSpace fieldSpace,String city,String street, String number){
        Address fieldAddress = new Address(city,street,number);

        return new SportField(null, fieldType,fieldSpace,fieldAddress,null);
    }

    public Long getId() {
        return id;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public FieldSpace getFieldSpace() {
        return fieldSpace;
    }

    public Address getAddress() {
        return address;
    }

    public List<SportEvent> getSportEvents() {
        return sportEvents;
    }
}

