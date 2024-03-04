package com.meeting.sport.app.sport_event;


import com.meeting.sport.app.sport_field.SportFieldResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SportEventResponse(
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer gameTime,
        int maxPlayers,
        int minAge,
        SportFieldResponse sportField,

        List<GameUserResponse> gameUserResponses
) {

}
