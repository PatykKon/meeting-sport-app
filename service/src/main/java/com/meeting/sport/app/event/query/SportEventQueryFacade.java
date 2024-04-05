package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.dto.SportFieldResponse;

import java.util.List;

public interface SportEventQueryFacade {

    List<SportEventResponse> getEvents();
    List<EventRoleResponse> getUserEvents(long userId);
    SportEventResponse getEventById(Long eventId);
    List<SportFieldResponse> getSportFields();

    SportFieldResponse getSportFieldByEvent(long sportEventId);
}