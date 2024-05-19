package com.meeting.sport.app.sport_event;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SportEventTest {


    @Test
    void leaveEvent() {

        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, 1L);
        sportEvent.addEventRoles(eventRole);

        sportEvent.leaveEvent(1L);

        assertNull(eventRole.getUserId());
        assertTrue(eventRole.isAvailable());
    }

    @Test
    void throwException_whenUserDoesNotExistInEvent_leaveEvent() {

        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent,1L);
        sportEvent.addEventRoles(eventRole);

        assertThrows(RuntimeException.class, () -> sportEvent.leaveEvent(999L));
    }

    @Test
    void assignToEvent() {
        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, null);
        sportEvent.addEventRoles(eventRole);

        sportEvent.joinToEvent(1L, GameRole.NAPASTNIK.toString());

        assertEquals(1L, eventRole.getUserId());
        assertFalse(eventRole.isAvailable());
    }

    @Test
    void throwException_whenEventStatusIsOtherThanComing_assignToEvent() {

        SportEvent sportEvent = prepareSportEvent1();
        EventRole eventRole = prepareEventRole(sportEvent, null);
        sportEvent.addEventRoles(eventRole);

        assertThrows(RuntimeException.class, () -> sportEvent.joinToEvent(1L, GameRole.NAPASTNIK.toString()));
    }

    @Test
    void throwException_whenGameRoleIsNotAvailable_assignToEvent() {

        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, 1L);
        sportEvent.addEventRoles(eventRole);

        assertThrows(RuntimeException.class, () -> sportEvent.joinToEvent(1L, GameRole.BRAMKARZ.toString()));
    }

    private SportEvent prepareSportEvent1() {
        return new SportEvent(
                1L,
                new Title("title"),
                new Description("description"),
                new Team(10, 5),
                new RequiredAge(15),
                new ArrayList<>(),
                new EventTime(1, LocalDateTime.now().plusDays(1)),
                2L,
                null,
                SportEventStatus.COMPLETED

        );
    }

    private SportEvent prepareSportEvent() {
            return new SportEvent(
                    1L,
                    new Title("title"),
                    new Description("description"),
                    new Team(10, 5),
                    new RequiredAge(15),
                    new ArrayList<>(),
                    new EventTime(1, LocalDateTime.of(2025,10,10,10,10)),
                    2L,
                    null,
                    SportEventStatus.COMING
            );
    }

    private EventRole prepareEventRole(SportEvent sportEvent, Long userId) {

        boolean isRoleAvailable = userId == null;

        return new EventRole(
                1L,
                GameRole.NAPASTNIK,
                sportEvent,
                isRoleAvailable,
                userId
        );
    }
}