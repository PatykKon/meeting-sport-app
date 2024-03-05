package com.meeting.sport.app.event;

import com.meeting.sport.app.event.Command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
