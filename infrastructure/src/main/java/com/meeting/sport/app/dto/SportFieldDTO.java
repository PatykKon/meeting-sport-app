package com.meeting.sport.app.dto;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.sport_field.FieldSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SportFieldDTO {

    private Long id;
    private String fieldType;
    private FieldSpace fieldSpace;
    private String city;
    private String street;
    private String number;

    private List<SportEventDTO> sportEventDTOS;



}
