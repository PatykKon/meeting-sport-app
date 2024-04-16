package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
class QuerySportEventServiceImpl implements QuerySportEventService{

    private final UserFacade userFacade;
    private final SportEventRepository sportEventRepository;

    public List<SportEventResponse> getEvents() {
        return sportEventRepository.findAllEntity()
                .stream()
                .map(SportEventMapper1::entityToResponse)
                .toList();
    }

    public SportEventResponse getEventById(Long eventId) {
        SportEventEntity eventEntity = sportEventRepository.findEntityById(eventId);
        return SportEventMapper1.entityToResponse(eventEntity);
    }

    public List<UserResponse> getEventUsers(Long eventId) {
        SportEvent sportEvent = sportEventRepository.findModelById(eventId);
        return sportEvent.getEventRoles().stream()
                .filter(er -> er.getUserId() != null)
                .map(eventRole -> userFacade.getUserResponse(eventRole.getUserId()))
                .collect(Collectors.toList());
    }
}
