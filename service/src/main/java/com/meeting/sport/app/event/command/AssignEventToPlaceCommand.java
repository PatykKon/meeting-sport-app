package com.meeting.sport.app.event.command;

public record AssignEventToPlaceCommand(
        Long sportEventId,
        Long sportFieldId
) implements Command {
}
