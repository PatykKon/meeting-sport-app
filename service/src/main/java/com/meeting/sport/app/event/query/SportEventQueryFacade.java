package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.SportEventResponse;

import java.util.List;

public interface SportEventQueryFacade {

    List<SportEventResponse> getEvent();
}