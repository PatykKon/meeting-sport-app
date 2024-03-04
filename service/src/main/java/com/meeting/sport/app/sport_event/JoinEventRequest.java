package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.Gamer;

public record JoinEventRequest(
        Gamer gamer,
        GameRole gameRole
) {
}
