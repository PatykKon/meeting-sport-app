package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import org.springframework.stereotype.Repository;

@Repository
public class EventRoleRepositoryImpl implements EventRoleRepository {

    private final EventRoleRepositoryJPA eventRoleRepositoryJPA;
    private final EventRoleMapper eventRoleMapper;

    public EventRoleRepositoryImpl(EventRoleRepositoryJPA eventRoleRepositoryJPA, EventRoleMapper eventRoleMapper) {
        this.eventRoleRepositoryJPA = eventRoleRepositoryJPA;
        this.eventRoleMapper = eventRoleMapper;
    }

    public EventRoleDTO getGameUser(long gameUserId){
        EventRoleEntity eventRoleEntity =  eventRoleRepositoryJPA.findById(gameUserId).orElseThrow();
        return eventRoleMapper.entityToDTO(eventRoleEntity);
    }
}
