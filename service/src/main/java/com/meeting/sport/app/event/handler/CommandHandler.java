package com.meeting.sport.app.event.handler;


import com.meeting.sport.app.event.command.Command;

interface CommandHandler<T extends Command> {
    Long handle(T command);


}
