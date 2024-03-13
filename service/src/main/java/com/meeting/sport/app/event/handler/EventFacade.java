package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EventFacade {

    private final CreateSportEventHandler createSportEventHandler;
    private final AddSportFieldHandler addSportFieldHandler;
    private final AssignEventToPlaceHandler assignEventToPlaceHandler;
    private final CreateGameRoleHandler createGameRoleHandler;
    private final JoinEventHandler joinEventHandler;

    @Autowired
    public EventFacade(CreateSportEventHandler createSportEventHandler, AddSportFieldHandler addSportFieldHandler, AssignEventToPlaceHandler assignEventToPlaceHandler, CreateGameRoleHandler createGameRoleHandler, JoinEventHandler joinEventHandler) {
        this.createSportEventHandler = createSportEventHandler;
        this.addSportFieldHandler = addSportFieldHandler;
        this.assignEventToPlaceHandler = assignEventToPlaceHandler;
        this.createGameRoleHandler = createGameRoleHandler;
        this.joinEventHandler = joinEventHandler;
    }

    public void createSportEvent(CreateSportEventCommand command){
        createSportEventHandler.handle(command);
    }
    public void addSportField(AddSportFieldCommand command){addSportFieldHandler.handle(command);}
    public void assignEventToPlace(AssignEventToPlaceCommand command){assignEventToPlaceHandler.handle(command);}
    public void createGameRole(CreateGameRoleCommand command){createGameRoleHandler.handle(command);}
    public void joinEvent(JoinEventCommand command){joinEventHandler.handle(command);}
}
