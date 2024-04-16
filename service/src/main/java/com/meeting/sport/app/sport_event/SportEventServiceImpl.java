package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
class SportEventServiceImpl implements SportEventService {

    private static final Logger logger = LogManager.getLogger(SportEventRepositoryImpl.class);

    private final EventRoleRepository eventRoleRepository;
    private final SportEventRepository sportEventRepository;


    public Long laveEvent(Long eventId, User loggedUser) {

        EventRole eventRole = eventRoleRepository.getEventRoleByUserAndEvent(eventId, loggedUser.getId());

        eventRole.leaveEvent();

        return eventRoleRepository.save(eventRole);
    }

    public Long joinEvent(Long eventId, String gameRole, User loggedUser) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        EventRole availableRole = getAvailableRole(sportEvent);

        checkUserExistInOtherEventInThisTime(eventId, loggedUser.getId());

        sportEvent.checkRequirements(loggedUser);

        availableRole.assignToEvent(loggedUser);
        return sportEventRepository.save(sportEvent);
    }

    public Long createGameRoles(Long eventId, List<EventRoleData> eventRoleDataList) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        EventRoleCreator.createEventRoles(eventRoleDataList, sportEvent);

        return sportEventRepository.save(sportEvent);
    }

    public Long assignFieldToSportEvent(Long sportEventId, SportField sportField) {
        SportEvent sportEvent = sportEventRepository.findModelById(sportEventId);
        sportEvent.assignSportField(sportField);

        return sportEventRepository.save(sportEvent);
    }

    public Long createSportEvent(String title,
                                 String description,
                                 int players,
                                 int minAge,
                                 LocalDateTime startTime,
                                 int gameTime,
                                 Long ownerId,
                                 int minPlayers) {

        SportEvent sportEvent = SportEvent.create(
                title,
                description,
                players,
                minAge,
                startTime,
                gameTime,
                ownerId,
                minPlayers);

        return sportEventRepository.save(sportEvent);
    }

    public void updateStatus() {
        try {
            logger.info("The updateEventStatus method was called" + LocalDateTime.now());

            List<SportEvent> sportEvents = sportEventRepository.findAllSportEventByStatus(SportEventStatus.COMING)
                    .stream()
                    .filter(e -> e.getEventTime().getStartTime().isBefore(LocalDateTime.now().plusDays(1)))
                    .toList();
            sportEvents.forEach(SportEvent::changeStatus);
            sportEventRepository.saveAll(sportEvents);

            logger.info("The call to updateEventStatus succeeded" + LocalDateTime.now());
        } catch (Exception e) {
            logger.error("An error occurred while updating event status: " + e.getMessage());

        }
    }

    private void checkUserExistInOtherEventInThisTime(Long eventId, Long userId) {

        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(userId);

        SportEvent sportEventToJoin = sportEventRepository.findModelById(eventId);

        final boolean isUserExistInOtherEventInThisTime = eventRoles.stream()
                .map(EventRole::getSportEvent)
                .anyMatch(sportEvent -> sportEvent.isInTheSameTime(sportEventToJoin.getEventTime()));

        if (isUserExistInOtherEventInThisTime) {
            throw new RuntimeException("Użytkownik o id:" + userId + " bierzę juz udział w tym czasie w innym wydarzeniu!");
        }
    }

    private EventRole getAvailableRole(SportEvent sportEvent){
        return sportEvent.getEventRoles()
                .stream()
                .filter(EventRole::isAvailable)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnegej Roli"));
    }
}
