package com.meeting.sport.app.sport_event.command;

import com.meeting.sport.app.Command;
import com.meeting.sport.app.sport_event.dto.EventRoleData;


import java.util.List;

public record CreateGameRoleCommand(
        Long sportEventId,
        List<EventRoleData> eventRoleDataList

) implements Command {
}
