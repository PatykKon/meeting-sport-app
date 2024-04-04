package com.meeting.sport.app.event.sport_event;

import com.meeting.sport.app.sport_event.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class SportEventServiceImpl implements SportEventService {

    private final EventRoleRepository eventRoleRepository;
    private final SportEventRepository sportEventRepository;

    @Override
    public EventRole getAvailableEventRoleById(Long eventId, GameRole gameRole) {
       return eventRoleRepository.findAvailableRole(eventId, gameRole);
    }

    @Override
    public SportEvent getEventById(Long eventId) {
        return sportEventRepository.findById(eventId);

    }

    @Override
    public Long saveEventRole(EventRole eventRole) {
       return eventRoleRepository.save(eventRole);
    }

    @Override
    public Long saveEvent(SportEvent sportEvent) {
        return sportEventRepository.save(sportEvent);
    }

    @Override
    public void checkUserExistInOtherEventInThisTime(Long eventId, Long userId) {

        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(userId);

        SportEvent sportEventToJoin = sportEventRepository.findById(eventId);

        final boolean isUserExistInOtherEventInThisTime = eventRoles.stream()
                .map(EventRole::getSportEvent)
                .anyMatch(sportEvent -> sportEvent.isInTheSameTime(sportEventToJoin.getEventTime()));

        if (isUserExistInOtherEventInThisTime) {
            throw new RuntimeException("Użytkownik o id:" + userId + " bierzę juz udział w tym czasie w innym wydarzeniu!");
        }
    }

    @Override
    public EventRole getUserEventRole(Long eventId, Long userId) {
        return eventRoleRepository.getEventRoleByUserAndEvent(eventId, userId);
    }
}
