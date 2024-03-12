package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRoleRepository {

    public EventRoleDTO getGameUser(long gameUserId);
}
