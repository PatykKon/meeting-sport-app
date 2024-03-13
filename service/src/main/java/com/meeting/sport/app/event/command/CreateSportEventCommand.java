package com.meeting.sport.app.event.command;

import com.meeting.sport.app.event.Command;

import java.time.LocalDateTime;


public record CreateSportEventCommand(
        String title,
        String description,
        int players,
        int minAge,
        LocalDateTime startTime,
        Integer gameTime
) implements Command {
}
