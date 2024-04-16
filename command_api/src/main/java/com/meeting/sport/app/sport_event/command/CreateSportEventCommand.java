package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;

import java.time.LocalDateTime;

public record CreateSportEventCommand(
        String title,
        String description,
        int players,
        int minAge,
        LocalDateTime startTime,
        Integer gameTime,
        String userEmail,
        int minPlayers
) implements Command {
}
