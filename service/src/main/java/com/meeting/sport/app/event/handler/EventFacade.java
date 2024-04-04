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

    public Long createSportEvent(CreateSportEventCommand command) {
        return createSportEventHandler.handle(command);
    }

    public Long addSportField(AddSportFieldCommand command) {
        return createSportFieldHandler.handle(command);
    }

    public Long assignEventToPlace(AssignEventToPlaceCommand command) {
        return assignEventToPlaceHandler.handle(command);
    }

    public Long createGameRole(CreateGameRoleCommand command) {
        return createGameRoleHandler.handle(command);
    }

    public Long joinEvent(JoinEventCommand command) {
        return joinEventHandler.handle(command);
    }

    public Long leaveEvent(LeaveEventCommand command) {
        return leaveEventHandler.handle(command);
    }
}
