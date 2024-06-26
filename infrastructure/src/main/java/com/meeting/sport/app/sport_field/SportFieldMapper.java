package com.meeting.sport.app.sport_field;

class SportFieldMapper {

    public static SportFieldEntity modelToEntity(SportField sportField) {

        SportFieldEntity.SportFieldEntityBuilder sportFieldEntity = SportFieldEntity.builder();

        sportFieldEntity.spaceField(sportField.getFieldSpace());
        sportFieldEntity.fieldType(sportField.getFieldType());
        sportFieldEntity.city(sportFieldAddressCity(sportField));
        sportFieldEntity.street(sportFieldAddressStreet(sportField));
        sportFieldEntity.number(sportFieldAddressNumber(sportField));
        sportFieldEntity.id(sportField.getId());

        return sportFieldEntity.build();
    }


    public static SportField entityToModel(SportFieldEntity sportFieldEntity) {

        Address address = sportFieldEntityToAddress(sportFieldEntity);
        FieldSpace fieldSpace = sportFieldEntity.getSpaceField();
        FieldType fieldType = sportFieldEntity.getFieldType();
        Long id = sportFieldEntity.getId();

        return new SportField(id, fieldType, fieldSpace, address);

    }


    public static SportFieldResponse entityToResponse(SportFieldEntity sportFieldEntity) {

        SportFieldResponse.SportFieldResponseBuilder sportFieldResponse = SportFieldResponse.builder();

        sportFieldResponse.id(sportFieldEntity.getId());
        sportFieldResponse.fieldSpace(sportFieldEntity.getSpaceField().toString());
        sportFieldResponse.fieldType(sportFieldEntity.getFieldType().toString());
        sportFieldResponse.city(sportFieldEntity.getCity());
        sportFieldResponse.street(sportFieldEntity.getStreet());
        sportFieldResponse.number(sportFieldEntity.getNumber());

        return sportFieldResponse.build();
    }

    private static String sportFieldAddressCity(SportField sportField) {

        Address address = sportField.getAddress();

        return address.getCity();

    }

    private static String sportFieldAddressStreet(SportField sportField) {

        Address address = sportField.getAddress();

        return address.getStreet();
    }

    private static String sportFieldAddressNumber(SportField sportField) {

        Address address = sportField.getAddress();

        return address.getNumber();

    }

    protected static Address sportFieldEntityToAddress(SportFieldEntity sportFieldEntity) {

        String city = sportFieldEntity.getCity();
        String street = sportFieldEntity.getStreet();
        String number = sportFieldEntity.getNumber();

        return new Address(city, street, number);

    }
}
