package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRoleRepository {

    EventRoleDTO findAvailableRole(long eventId,GameRole gameRole);

    void save(EventRoleDTO eventRoleDTO);

    boolean isUserExistInEvent(long eventId,long userId);
}
