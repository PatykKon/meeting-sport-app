package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;

public record JoinEventCommand(

        Long eventId,
        String gameRole,
        String userEmail
) implements Command {
}
