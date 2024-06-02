package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class QuerySportEventServiceImpl implements QuerySportEventService {

    private final UserFacade userFacade;
    private final SportEventRepository sportEventRepository;
    private final EventRoleRepository eventRoleRepository;

    public List<SportEventResponse> getEvents() {
        return sportEventRepository.findAllSportEvent()
                .stream()
                .map(SportEventMapper::modelToResponse)
                .toList();
    }

    @Override
    public SportEventResponse getEventById(Long eventId) {
        SportEvent sportEvent = sportEventRepository.findById(eventId);
        return SportEventMapper.modelToResponse(sportEvent);
    }

    @Override
    public List<UserResponse> getEventUsers(Long eventId) {
        SportEvent sportEvent = sportEventRepository.findById(eventId);
        return sportEvent.getEventRoles().stream()
                .filter(er -> er.getUserId() != null)
                .map(eventRole -> userFacade.getUserResponse(eventRole.getUserId()))
                .toList();
    }

    @Override
    public List<EventRoleResponse> getEventsForUser(Long userId) {
        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(userId);

        return eventRoles.stream()
                .map(EventRoleMapper::modelToResponse)
                .toList();

    }
}
