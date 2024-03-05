package com.meeting.sport.app.event.command;

import com.meeting.sport.app.event.Command;
import com.meeting.sport.app.sport_event.GameRole;

public record JoinEventCommand(

        Long eventId,
        GameRole gameRole
) implements Command {


}
