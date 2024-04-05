package com.meeting.sport.app.event.command;

import com.meeting.sport.app.sport_event.EventRoleData;


import java.util.List;

public record CreateGameRoleCommand(
        Long sportEventId,
        List<EventRoleData> eventRoleDataList

) implements Command {
}
