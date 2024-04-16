package com.meeting.sport.app;

public interface CommandHandler<T extends Command> {
    Long handle(T command);


}
