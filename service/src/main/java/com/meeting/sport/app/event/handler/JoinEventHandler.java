package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.sport_event.Gamer;
import com.meeting.sport.app.event.command.JoinEventCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class JoinEventHandler implements CommandHandler<JoinEventCommand> {

    private final SportEventRepository sportEventRepository;

    @Autowired
    JoinEventHandler(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public void handle(JoinEventCommand command) {
        SportEvent sportEvent = sportEventRepository.findById(command.eventId());
        Gamer gamer = new Gamer(20);

        sportEvent.joinToEvent(gamer,command.gameRole());
        sportEventRepository.save(sportEvent);


    }
}
