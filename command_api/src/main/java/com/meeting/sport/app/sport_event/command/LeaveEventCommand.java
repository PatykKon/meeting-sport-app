package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;

public record LeaveEventCommand(
        Long eventId,
        String userEmail
) implements Command {
}