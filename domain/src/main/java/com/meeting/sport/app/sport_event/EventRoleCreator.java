package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;

import java.util.List;
import java.util.stream.IntStream;

class EventRoleCreator {

    public static void createEventRoles(List<EventRoleData> eventRoleDataList, SportEvent sportEvent){
        if (!sportEvent.getEventRoles().isEmpty()) {
            throw new RuntimeException("this have already user role list");
        }
        final int sumGameRole = getSumGameRole(eventRoleDataList);

        if (sumGameRole != sportEvent.getTeamSize().getTeamSize()) {
            throw new RuntimeException("game roles can not be less than declared number of players: " + sportEvent.getTeamSize().getTeamSize());
        }

        List<EventRole> eventRoles = eventRoleDataList.stream()
                .flatMap(eventRoleData -> IntStream.range(0, eventRoleData.numberOfPlayers())
                        .mapToObj(i -> EventRole.crateAvailableEventRole(eventRoleData.gameRole(), sportEvent)))
                .toList();

        eventRoles.forEach(sportEvent::addEventRoles);
    }

    private static int getSumGameRole(List<EventRoleData> eventRoleDataList) {
        return eventRoleDataList.stream()
                .mapToInt(EventRoleData::numberOfPlayers)
                .sum();
    }
}
