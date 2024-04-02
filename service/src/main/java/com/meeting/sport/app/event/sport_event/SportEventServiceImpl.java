package com.meeting.sport.app.event.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.event.user.UserService;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

        public void checkUserExistInOtherEventInThisTime(Long eventId, Long userId){

            List<EventRoleDTO> eventRoleListDTO = eventRoleRepository.getEventRoleEntitiesByUserEntityId(userId);
            List<EventRole> eventRoles = eventRoleListDTO.stream().map(eventRoleMapper::DTOToModel).toList();

            SportEvent sportEventToJoin = sportEventMapper.DTOToModel(sportEventRepository.findById(eventId));

            final boolean isUserExistInOtherEventInThisTime = eventRoles.stream()
                    .map(EventRole::getSportEvent)
                    .anyMatch(sportEvent -> sportEvent.isInTheSameTime(sportEventToJoin.getEventTime()));

            if(isUserExistInOtherEventInThisTime){
                throw new RuntimeException("Użytkownik o id:" + userId + " bierzę juz udział w tym czasie w innym wydarzeniu!");
            }
        }


    @Override
    public EventRole getUserEventRole(Long eventId, Long userId) {
        EventRoleDTO eventRoleDTO = eventRoleRepository.getEventRoleByUserAndEvent(eventId,userId);
        return eventRoleMapper.DTOToModel(eventRoleDTO);
    }
}
