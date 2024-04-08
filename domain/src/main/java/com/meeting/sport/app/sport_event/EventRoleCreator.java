package com.meeting.sport.app.sport_event;

import java.util.List;
import java.util.stream.IntStream;

public class EventRoleCreator {

    public static List<EventRole> createEventRoles(List<EventRoleData> eventRoleDataList, SportEvent sportEvent){
        if (!sportEvent.getEventRoles().isEmpty()) {
            throw new RuntimeException("this have already user role list");
        }
        final int sumGameRole = getSumGameRole(eventRoleDataList);

        if (sumGameRole != sportEvent.getNumberOfPlayers()) {
            throw new RuntimeException("game roles can not be less than declared number of players: " + sportEvent.getNumberOfPlayers());
        }

        return eventRoleDataList.stream()
                .flatMap(eventRoleData -> IntStream.range(0, eventRoleData.numberOfPlayers())
                        .mapToObj(i -> EventRole.crateAvailableEventRole(eventRoleData.gameRole(), sportEvent)))
                .toList();
    }

    private static int getSumGameRole(List<EventRoleData> eventRoleDataList) {
        return eventRoleDataList.stream()
                .mapToInt(EventRoleData::numberOfPlayers)
                .sum();
    }
}