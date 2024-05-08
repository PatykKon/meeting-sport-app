package com.meeting.sport.app.sport_field.command;

import com.meeting.sport.app.Command;

public record AddSportFieldCommand(
        String fieldType,
        String fieldSpace,
        String city,
        String street,
        String number
) implements Command {
}
