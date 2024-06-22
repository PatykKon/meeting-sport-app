package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.sport_event.exceptions.EventRoleCreationException;

import java.util.List;
import java.util.stream.IntStream;

class EventRoleCreator {

    private EventRoleCreator(){
    }

    public static List<EventRole> createEventRoles(List<EventRoleData> eventRoleDataList, SportEvent sportEvent){
        final int sumGameRole = getSumGameRole(eventRoleDataList);

        if (sumGameRole != sportEvent.getTeamSize().getTeamSize()) {
        throw new EventRoleCreationException("game roles can not be less than declared number of players: " + sportEvent.getTeamSize().getTeamSize());
        }

        return eventRoleDataList.stream()
                .flatMap(eventRoleData -> IntStream.range(0, eventRoleData.numberOfPlayers())
                        .mapToObj(e -> EventRole.crateAvailableEventRole(eventRoleData.gameRole(), sportEvent)))
                .toList();
    }

    private static int getSumGameRole(List<EventRoleData> eventRoleDataList) {
        return eventRoleDataList.stream()
                .mapToInt(EventRoleData::numberOfPlayers)
                .sum();
    }
}
