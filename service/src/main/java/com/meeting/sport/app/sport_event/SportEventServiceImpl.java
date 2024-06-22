package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.sport_event.exceptions.EventRoleCreationException;
import com.meeting.sport.app.sport_event.exceptions.JoinEventException;
import com.meeting.sport.app.sport_event.exceptions.NoAvailableRoleException;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
class SportEventServiceImpl implements SportEventService {

    private static final Logger logger = LogManager.getLogger(SportEventServiceImpl.class);

    private final SportEventRepository sportEventRepository;
    private final JoinedValidator joinedValidator;
    private final DeleteEventValidator deleteEventValidator;

    @Override
    @Transactional
    public Long laveEvent(Long eventId, Long loggedUserId) {

        SportEvent sportEvent = sportEventRepository.findById(eventId);

        sportEvent.leaveEvent(loggedUserId);

        return sportEventRepository.save(sportEvent);
    }

    @Override
    @Transactional
    public Long joinEvent(Long eventId, String gameRole, UserDTO loggedUser) {
        try {
            SportEvent sportEvent = sportEventRepository.findById(eventId);

            joinedValidator.validate(sportEvent, loggedUser);
            sportEvent.joinToEvent(loggedUser.id(), gameRole);

            return sportEventRepository.save(sportEvent);
        } catch (NoAvailableRoleException | JoinEventException e) {
            logger.error("An error occurred while join to event: " + eventId + e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            logger.error("An unexpected error occurred while joining event: " + eventId + ". " + e.getMessage(), e);
            throw new RuntimeException("Unexpected error occurred while joining event", e);
        }
    }

    @Override
    @Transactional
    public Long createGameRoles(Long eventId, List<EventRoleData> eventRoleDataList) {

        try {
            SportEvent sportEvent = sportEventRepository.findById(eventId);
            sportEvent.addEventRoles(eventRoleDataList);
            return sportEventRepository.save(sportEvent);
        } catch (EventRoleCreationException e) {
            logger.error("An unexpected error occurred while creating role for event: " + eventId + ". " + e.getMessage(), e);
            throw new RuntimeException("Unexpected error occurred while creating role for event", e);
        }
    }

    @Override
    @Transactional
    public Long assignFieldToSportEvent(Long sportEventId, Long sportFieldId) {
        SportEvent sportEvent = sportEventRepository.findById(sportEventId);

        sportEvent.assignSportField(sportFieldId);

        return sportEventRepository.save(sportEvent);
    }

    @Override
    @Transactional
    public Long updateEvent(Long sportEventId,
                            String title,
                            String description,
                            Integer players,
                            Integer minAge,
                            LocalDateTime startTime,
                            Integer gameTime,
                            Long ownerId,
                            Integer minPlayers) {

        SportEvent sportEvent = sportEventRepository.findById(sportEventId);

        sportEvent.updateEvent(
                ownerId,
                description,
                title,
                minAge,
                gameTime,
                players,
                minPlayers,
                startTime);

        return sportEventRepository.save(sportEvent);
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void deleteSportEvent(Long sportEventId, Long userId) {

        SportEvent sportEvent = sportEventRepository.findById(sportEventId);

        deleteEventValidator.validate(userId, sportEvent);

        sportEventRepository.delete(sportEvent);

    }

    @Override
    @Transactional
    public void updateStatus() {
        try {
            logger.info("The updateEventStatus method was called" + LocalDateTime.now());

            List<SportEvent> sportEvents = getSportEventToCheckStatus();
            if (sportEvents.isEmpty()) {
                logger.info("No Events To check");
                return;
            }

            sportEvents.forEach(SportEvent::changeStatus);
            sportEventRepository.saveAll(sportEvents);

            logger.info("The call to updateEventStatus succeeded" + LocalDateTime.now());
        } catch (Exception e) {
            logger.error("An error occurred while updating event status: " + e.getMessage());

        }
    }

    private List<SportEvent> getSportEventToCheckStatus() {

        final LocalDateTime dateToCheckStatus = LocalDateTime.now().minusHours(SportEventConstants.HOUR_LEFT_TO_CHECK_STATUS);

        return sportEventRepository.findAllSportEventByTime(dateToCheckStatus);
    }
}
