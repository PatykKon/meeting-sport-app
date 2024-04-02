package com.meeting.sport.app.event.command;

import com.meeting.sport.app.sport_event.GameRole;

public record LeaveEventCommand(
        Long eventId,
        String userEmail
) implements Command {
}