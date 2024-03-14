package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class EventRoleRepositoryImpl implements EventRoleRepository {

    private final EventRoleRepositoryJPA eventRoleRepositoryJPA;
    private final EventRoleMapper eventRoleMapper;

    public EventRoleRepositoryImpl(EventRoleRepositoryJPA eventRoleRepositoryJPA, EventRoleMapper eventRoleMapper) {
        this.eventRoleRepositoryJPA = eventRoleRepositoryJPA;
        this.eventRoleMapper = eventRoleMapper;
    }

    @Override
    public EventRoleDTO findAvailableRole(long eventId, GameRole gameRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.findBySportEventEntityIdAndGameRoleAndIsAvailableTrue(eventId, gameRole)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));

        return eventRoleMapper.entityToDTO(entity);
    }

    public void save(EventRoleDTO dto){
        eventRoleRepositoryJPA.save(eventRoleMapper.DTOToEntity(dto));
    }

    @Override
    public boolean isUserExistInEvent(long eventId, long userId) {
        return eventRoleRepositoryJPA.isUserExistInEvent(eventId,userId);
    }
}
