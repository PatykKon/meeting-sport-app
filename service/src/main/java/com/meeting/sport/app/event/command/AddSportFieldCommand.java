package com.meeting.sport.app.event.command;

import com.meeting.sport.app.event.Command;
import com.meeting.sport.app.sport_field.FieldSpace;
import com.meeting.sport.app.sport_field.FieldType;

public record AddSportFieldCommand(
        FieldType fieldType,
        FieldSpace fieldSpace,
        String city,
        String street,
        String number
) implements Command {
}
