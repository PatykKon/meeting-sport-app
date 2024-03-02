package com.meeting.sport.app.sport_field;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SportField {

    private final Long id;
    FieldType fieldType;
    FieldSpace fieldSpace;


    public SportField(Long id,FieldType fieldType, FieldSpace fieldSpace) {
        this.id = id;
        this.fieldType = fieldType;
        this.fieldSpace = fieldSpace;
    }
}

