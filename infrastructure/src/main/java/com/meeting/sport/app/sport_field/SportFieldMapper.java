package com.meeting.sport.app.sport_field;

public class SportFieldMapper {

    public static SportFieldEntity toEntity(SportField sportField) {
        return SportFieldEntity.builder()
                .id(sportField.getId())
                .fieldType(sportField.fieldType)
                .fieldSpace(sportField.getFieldSpace())
                .build();

    }

    public static SportField toModel(SportFieldEntity sportFieldEntity) {
        return SportField.builder()
                .id(sportFieldEntity.getId())
                .fieldType(sportFieldEntity.getFieldType())
                .fieldSpace(sportFieldEntity.getFieldSpace())
                .build();


    }
}
