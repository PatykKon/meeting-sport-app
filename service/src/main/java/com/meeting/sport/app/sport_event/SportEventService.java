package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class SportEventService {

    private final SportEventRepository sportEventRepository;
    private final SportFieldRepository sportFieldRepository;

    void makeSportEvent(Long sportFieldId, SportEventRequest sportEventRequest) {

        SportField sportField = sportFieldRepository.findById(sportFieldId);

        SportEvent sportEvent = SportEvent.create(
                sportEventRequest.title(),
                sportEventRequest.description(),
                sportEventRequest.players(),
                sportEventRequest.minAge(),
                sportField,
                sportEventRequest.startTime(),
                sportEventRequest.gameTime());

        sportEventRepository.save(sportEvent);


        List<GameUser> gameUsers = GameUser.crateGameUsers(sportEventRequest.gameRoles(),sportEvent);

        sportEvent.addGameUsers(gameUsers);

        sportEventRepository.save(sportEvent);
    }

    SportEventResponse getEvent(Long eventId) {
        return sportEventRepository.getSportEvent(eventId);
    }

    void joinEvent(JoinEventRequest request,Long eventId){

        SportEvent sportEvent = sportEventRepository.findById(eventId);
        sportEvent.join(request.gamer(),request.gameRole());

    }
}

