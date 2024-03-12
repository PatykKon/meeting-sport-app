package com.meeting.sport.app.dto;



import com.meeting.sport.app.user.UserResponse;
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
        int activePlayers,
        SportFieldResponse sportFieldResponse,
        List<EventRoleResponse> eventRoleResponse,
        List<UserResponse> userResponse
) {

    public int activePlayers(){
        return eventRoleResponse().stream().filter(s -> !s.isAvailable()).toList().size();
    }

}
