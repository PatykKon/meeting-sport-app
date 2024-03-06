package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
public class SportField {

    private Long id;
    private FieldType fieldType;
    private FieldSpace fieldSpace;
    private Address address;
    private List<SportEvent> sportEvents;

    public SportField() {
    }

    public SportField(Long id, FieldType fieldType, FieldSpace fieldSpace, Address address, List<SportEvent> sportEvents) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
        this.address = address;
        this.sportEvents = sportEvents;
    }

    private SportField(Long id, FieldType fieldType, FieldSpace fieldSpace, Address address) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
        this.address = address;
    }

    public static SportField addSportField(FieldType fieldType, FieldSpace fieldSpace,String city,String street, String number){
        Address fieldAddress = new Address(city,street,number);

        return new SportField(null, fieldType,fieldSpace,fieldAddress);
    }

    public void addEventToSportField(SportEvent sportEvent) {
        if (sportEvent == null) {
            throw new RuntimeException("can not add empty event");
        }
        this.sportEvents.add(sportEvent);
    }
}

