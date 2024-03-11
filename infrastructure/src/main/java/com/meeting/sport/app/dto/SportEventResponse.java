package com.meeting.sport.app.dto;



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
        ActivePlayers activePlayers,
        SportFieldResponse sportFieldResponse,
        List<GameUserResponse> gameUserResponse,
        List<GamerResponse> gamerResponse
) {

    public ActivePlayers activePlayers(){
        int activePlayers = gameUserResponse().stream().filter(s -> !s.isAvailable()).toList().size();
        return new ActivePlayers(activePlayers);
    }

}
