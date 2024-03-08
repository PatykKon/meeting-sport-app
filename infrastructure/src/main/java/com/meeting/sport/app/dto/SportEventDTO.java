package com.meeting.sport.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class SportEventDTO {
    private Long id;
    private String title;
    private String description;
    private int players;
    private int minAge;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer gameTime;
    private SportFieldDTO sportFieldDTO;
    private List<GameUserDTO> gameUserDTOS;

    public List<GameUserDTO> getGameUserDTOS() {
        if(gameUserDTOS == null){
            gameUserDTOS = new ArrayList<>();
        }
        return gameUserDTOS;
    }

}
