package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;

import java.time.LocalDateTime;

public record UpdateEventCommand(
        Long eventId,
        String userEmail,
        String title,
        String description,
        Integer players,
        Integer minAge,
        LocalDateTime startTime,
        Integer gameTime,
        Integer minPlayers
) implements Command {
}