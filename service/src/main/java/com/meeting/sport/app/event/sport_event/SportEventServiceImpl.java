package com.meeting.sport.app.event.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.sport_event.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportEventServiceImpl implements SportEventService {

    private final EventRoleRepository eventRoleRepository;
    private final EventRoleMapper eventRoleMapper;
    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    @Override
    public EventRole getAvailableEventRoleById(Long eventId, GameRole gameRole) {
        EventRoleDTO eventRoleDTO = eventRoleRepository.findAvailableRole(eventId, gameRole);
        return eventRoleMapper.DTOToModel(eventRoleDTO);
    }

    @Override
    public SportEvent getEventById(Long eventId) {
        SportEventDTO sportEventDTO = sportEventRepository.findById(eventId);
        return sportEventMapper.DTOToModel(sportEventDTO);
    }

    @Override
    public void saveEventRole(EventRole eventRole) {
        eventRoleRepository.save(eventRole);
    }

    @Override
    public void saveEvent(SportEvent sportEvent) {
        sportEventRepository.save(sportEvent);
    }

    @Override
    public boolean isUserExistInEvent(Long eventId, Long userId) {
        return eventRoleRepository.isUserExistInEvent(eventId, userId);
    }
}
