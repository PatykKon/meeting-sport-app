package com.meeting.sport.app.event;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
