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

    private final SportEventRepository sportEventRepository;
    private final JoinedValidator joinedValidator;


    public Long laveEvent(Long eventId, Long loggedUserId) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        sportEvent.leaveEvent(loggedUserId);

        return sportEventRepository.save(sportEvent);
    }

    public Long joinEvent(Long eventId, String gameRole, User loggedUser) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        EventRole availableRole = getAvailableRole(sportEvent);

        joinedValidator.validate(sportEvent, loggedUser);

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

    public void deleteSportEvent(Long sportEventId, Long userId) {

        SportEvent sportEvent = sportEventRepository.findModelById(sportEventId);

        if (!sportEvent.getOwnerId().equals(userId)) {
            throw new RuntimeException("only owner can delete event");
        }

        sportEventRepository.delete(sportEvent);

    }

    public void updateStatus() {
        try {
            logger.info("The updateEventStatus method was called" + LocalDateTime.now());

//            List<SportEvent> sportEvents = sportEventRepository.findAllSportEventByStatus(SportEventStatus.COMING)
//                    .stream()
//                    .filter(SportEvent::isDaysInCheckingRange)
//                    .toList();
            final int hourLeftToCheck = 2;
            final LocalDateTime dateToCheckStatus = LocalDateTime.now().minusHours(hourLeftToCheck);

            List<SportEvent> sportEvents = sportEventRepository.findAllSportEventByTime(dateToCheckStatus);

            sportEvents.forEach(SportEvent::changeStatus);
            sportEventRepository.saveAll(sportEvents);

            logger.info("The call to updateEventStatus succeeded" + LocalDateTime.now());
        } catch (Exception e) {
            logger.error("An error occurred while updating event status: " + e.getMessage());

        }
    }

    private EventRole getAvailableRole(SportEvent sportEvent) {
        return sportEvent.getEventRoles()
                .stream()
                .filter(EventRole::isAvailable)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnegej Roli"));
    }
}
