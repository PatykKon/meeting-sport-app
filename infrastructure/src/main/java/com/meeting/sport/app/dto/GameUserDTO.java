package com.meeting.sport.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class GameUserDTO {
    private Long id;
    private String gameRole;
    private boolean isAvailable;
    private SportEventDTO sportEventDTO;
}
