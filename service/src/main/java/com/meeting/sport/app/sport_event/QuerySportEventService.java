package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.dto.UserResponse;

import java.util.List;

interface QuerySportEventService {

    List<SportEventResponse> getEvents();

    SportEventResponse getEventById(Long eventId);

    List<UserResponse> getEventUsers(Long eventId);

    List<EventRoleResponse> getEventsForUser(Long userId);
}
