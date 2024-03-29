package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EventFacade {

    private final CreateSportEventHandler createSportEventHandler;
    private final CreateSportFieldHandler createSportFieldHandler;
    private final AssignEventToPlaceHandler assignEventToPlaceHandler;
    private final CreateGameRoleHandler createGameRoleHandler;
    private final JoinEventHandler joinEventHandler;
    private final LeaveEventHandler leaveEventHandler;

    @Autowired
    public EventFacade(CreateSportEventHandler createSportEventHandler, CreateSportFieldHandler createSportFieldHandler, AssignEventToPlaceHandler assignEventToPlaceHandler, CreateGameRoleHandler createGameRoleHandler, JoinEventHandler joinEventHandler, LeaveEventHandler leaveEventHandler) {
        this.createSportEventHandler = createSportEventHandler;
        this.createSportFieldHandler = createSportFieldHandler;
        this.assignEventToPlaceHandler = assignEventToPlaceHandler;
        this.createGameRoleHandler = createGameRoleHandler;
        this.joinEventHandler = joinEventHandler;
        this.leaveEventHandler = leaveEventHandler;
    }

    public void createSportEvent(CreateSportEventCommand command) {
        createSportEventHandler.handle(command);
    }

    public void addSportField(AddSportFieldCommand command) {
        createSportFieldHandler.handle(command);
    }

    public void assignEventToPlace(AssignEventToPlaceCommand command) {
        assignEventToPlaceHandler.handle(command);
    }

    public void createGameRole(CreateGameRoleCommand command) {
        createGameRoleHandler.handle(command);
    }

    public void joinEvent(JoinEventCommand command) {
        joinEventHandler.handle(command);
    }

    public void leaveEvent(LeaveEventCommand command){leaveEventHandler.handle(command);}
}
