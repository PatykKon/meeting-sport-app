package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;

public record AssignEventToPlaceCommand(
        Long sportEventId,
        Long sportFieldId
) implements Command {
}
