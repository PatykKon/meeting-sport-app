package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
class SportEventServiceImpl implements SportEventService {

    private static final Logger logger = LogManager.getLogger(SportEventRepositoryImpl.class);

    private final SportEventRepository sportEventRepository;
    private final JoinedValidator joinedValidator;
    private final DeleteEventValidator deleteEventValidator;

    @Override
    public Long laveEvent(Long eventId, Long loggedUserId) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        sportEvent.leaveEvent(loggedUserId);

        return sportEventRepository.save(sportEvent);
    }

    @Override
    public Long joinEvent(Long eventId, String gameRole, UserDTO loggedUser) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        joinedValidator.validate(sportEvent, loggedUser);

        sportEvent.joinToEvent(loggedUser.id(), gameRole);
        return sportEventRepository.save(sportEvent);
    }

    @Override
    public Long createGameRoles(Long eventId, List<EventRoleData> eventRoleDataList) {

        SportEvent sportEvent = sportEventRepository.findModelById(eventId);

        EventRoleCreator.createEventRoles(eventRoleDataList, sportEvent);

        return sportEventRepository.save(sportEvent);
    }

    @Override
    public Long assignFieldToSportEvent(Long sportEventId, Long sportFieldId) {
        SportEvent sportEvent = sportEventRepository.findModelById(sportEventId);
        sportEvent.assignSportField(sportFieldId);

        return sportEventRepository.save(sportEvent);
    }

    public Long updateEvent(Long sportEventId,
                            String title,
                            String description,
                            int players,
                            int minAge,
                            LocalDateTime startTime,
                            int gameTime,
                            Long ownerId,
                            int minPlayers) {

        SportEvent sportEvent = sportEventRepository.findModelById(sportEventId);

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
    public void deleteSportEvent(Long sportEventId, Long userId) {

        SportEvent sportEvent = sportEventRepository.findModelById(sportEventId);

        deleteEventValidator.validate(userId, sportEvent);

        sportEventRepository.delete(sportEvent);

    }

    @Override
    public void updateStatus() {
        try {
            logger.info("The updateEventStatus method was called" + LocalDateTime.now());

            List<SportEvent> sportEvents = getSportEventToCheckStatus();

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
