package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.User;
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

    public void validate(SportEvent sportEvent, User loggedUser) {

        try {
            checkUserExistInOtherEventInThisTime(sportEvent, loggedUser);
            validateUser(sportEvent, loggedUser);
        } catch (Exception e) {
            logger.error("Validation failed for user: " + loggedUser.getId() + " and event: " + sportEvent.getId(), e);
            throw new RuntimeException("Validation failed");
        }
    }

    private void checkUserExistInOtherEventInThisTime(SportEvent sportEventToJoin, User loggedUser) {

        List<EventRole> eventRoles = eventRoleRepository.getEventRoleEntitiesByUserEntityId(loggedUser.getId());

        final boolean isUserExistInOtherEventInThisTime = eventRoles.stream()
                .map(EventRole::getSportEvent)
                .anyMatch(sportEvent -> sportEvent.getEventTime().isEventInTheSameTime(sportEventToJoin.getEventTime()));

        if (isUserExistInOtherEventInThisTime) {
            throw new RuntimeException("Użytkownik o id:" + loggedUser.getId() + " bierzę juz udział w tym czasie w innym wydarzeniu!");
        }
    }

    private void validateUser(SportEvent sportEvent, User loggedUser) {
        sportEvent.getRequiredAge().validateAge(loggedUser.getAge());

    }
}
