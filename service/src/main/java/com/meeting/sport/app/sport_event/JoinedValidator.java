package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.exceptions.JoinEventException;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class JoinedValidator {

    private final EventRoleRepository eventRoleRepository;

    private static final Logger logger = LoggerFactory.getLogger(JoinedValidator.class);

    void validate(SportEvent sportEvent, UserDTO loggedUser) {

        try {
            checkUserExistInOtherEventInThisTime(sportEvent, loggedUser.id());
            validateUser(sportEvent, loggedUser.age());
        } catch (JoinEventException e) {
            logger.error("Validation failed for user: " + loggedUser.id() + " and event: " + sportEvent.getId(), e);
            throw e;
        }catch (Exception e){
            logger.error("Unexpected validation error for user: " + loggedUser.id() + " and event: " + sportEvent.getId(), e);
            throw new RuntimeException("Validation failed", e);
        }
    }

    private void checkUserExistInOtherEventInThisTime(SportEvent sportEventToJoin, Long loggedUserId) {

        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(loggedUserId);

        final boolean isUserExistInOtherEventInThisTime = eventRoles.stream()
                .map(EventRole::getSportEvent)
                .anyMatch(sportEvent -> sportEvent.getEventTime().isEventInTheSameTime(sportEventToJoin.getEventTime()));

        if (isUserExistInOtherEventInThisTime) {
            throw new JoinEventException("Użytkownik o id:" + loggedUserId + " bierzę juz udział w tym czasie w innym wydarzeniu!");
        }
    }

    private void validateUser(SportEvent sportEvent, int loggedUserAge) {
        sportEvent.getRequiredAge().validateAge(loggedUserAge);

    }
}
