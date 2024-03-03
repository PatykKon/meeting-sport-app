package com.meeting.sport.app.sport_field;

public class SportFieldMapper {

    public static SportFieldEntity toEntity(SportField sportField) {
        return SportFieldEntity.builder()
                .id(sportField.getId())
                .fieldType(sportField.getFieldType())
                .spaceField(sportField.getFieldSpace())
                .city(sportField.getAddress().getCity())
                .street(sportField.getAddress().getStreet())
                .number(sportField.getAddress().getNumber())
                .build();
    }

    public static SportField toModel(SportFieldEntity sportFieldEntity) {
        return SportField.builder()
                .id(sportFieldEntity.getId())
                .fieldType(sportFieldEntity.getFieldType())
                .fieldSpace(sportFieldEntity.getSpaceField())
                .address(new Address(sportFieldEntity.getCity(), sportFieldEntity.getStreet(), sportFieldEntity.getNumber()))
                .build();
    }

    public static SportFieldResponse toResponse(SportFieldEntity entity) {
        return SportFieldResponse.builder()
                .city(entity.getCity())
                .street(entity.getStreet())
                .number(entity.getNumber())
                .fieldSpace(entity.getSpaceField())
                .fieldType(entity.getFieldType())
                .build();
    }
}
