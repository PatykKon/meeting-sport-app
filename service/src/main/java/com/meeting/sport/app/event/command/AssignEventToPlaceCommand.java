package com.meeting.sport.app.event.command;


import com.meeting.sport.app.event.Command;

public record AssignEventToPlaceCommand(
        Long sportEventId,
        Long sportFieldId
) implements Command {
}
