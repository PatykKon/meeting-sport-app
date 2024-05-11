package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
class QuerySportEventServiceImpl implements QuerySportEventService {

    private final UserFacade userFacade;
    private final SportEventRepository sportEventRepository;
    private final EventRoleRepository eventRoleRepository;

    public List<SportEventResponse> getEvents() {
        return sportEventRepository.findAllEntity()
                .stream()
                .map(SportEventMapper::entityToResponse)
                .toList();
    }

    @Override
    public SportEventResponse getEventById(Long eventId) {
        SportEventEntity eventEntity = sportEventRepository.findEntityById(eventId);
        return SportEventMapper.entityToResponse(eventEntity);
    }

    @Override
    public List<UserResponse> getEventUsers(Long eventId) {
        SportEvent sportEvent = sportEventRepository.findModelById(eventId);
        return sportEvent.getEventRoles().stream()
                .filter(er -> er.getUserId() != null)
                .map(eventRole -> userFacade.getUserResponse(eventRole.getUserId()))
                .toList();
    }

    @Override
    public List<EventRoleResponse> getEventsForUser(Long userId) {
        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(userId);
        List<EventRoleEntity> eventRoleEntities = eventRoles
                .stream()
                .map(EventRoleMapper::modelToEntity)
                .toList();

        return eventRoleEntities.stream()
                .map(EventRoleMapper::entityToResponse)
                .toList();

    }
}
