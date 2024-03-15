package com.meeting.sport.app.event.command;

import com.meeting.sport.app.sport_event.GameRole;

import java.util.List;

public record CreateGameRoleCommand(
        Long sportEventId,
        List<GameRole> playerTypes
) implements Command {
}
