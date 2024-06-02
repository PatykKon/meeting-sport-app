package com.meeting.sport.app.sport_event;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SportEventTest {

    @Test
    void leaveEvent() {
        //given
        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, 1L);
        sportEvent.addEventRole(eventRole);

        //when
        sportEvent.leaveEvent(1L);

        //then
        assertNull(eventRole.getUserId());
        assertTrue(eventRole.isAvailable());
    }

    @Test
    void throwException_whenUserDoesNotExistInEvent_leaveEvent() {
        //given
        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, 1L);
        sportEvent.addEventRole(eventRole);

        //when
        //then
        assertThrows(RuntimeException.class, () -> sportEvent.leaveEvent(999L));
    }

    @Test
    void assignToEvent() {
        //given
        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, null);
        sportEvent.addEventRole(eventRole);

        //when
        sportEvent.joinToEvent(1L, GameRole.NAPASTNIK.toString());

        //then
        assertEquals(1L, eventRole.getUserId());
        assertFalse(eventRole.isAvailable());
    }

    @Test
    void throwException_whenEventStatusIsOtherThanComing_assignToEvent() {
        //given
        SportEvent sportEvent = prepareSportEvent1();
        EventRole eventRole = prepareEventRole(sportEvent, null);
        sportEvent.addEventRole(eventRole);

        //when
        //then
        assertThrows(RuntimeException.class, () -> sportEvent.joinToEvent(1L, GameRole.NAPASTNIK.toString()));
    }

    @Test
    void throwException_whenGameRoleIsNotAvailable_assignToEvent() {
        //given
        SportEvent sportEvent = prepareSportEvent();
        EventRole eventRole = prepareEventRole(sportEvent, 1L);
        sportEvent.addEventRole(eventRole);

        //when
        //then
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
                new EventTime(1, LocalDateTime.of(2025, 10, 10, 10, 10)),
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