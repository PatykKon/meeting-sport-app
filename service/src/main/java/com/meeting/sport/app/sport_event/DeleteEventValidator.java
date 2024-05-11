package com.meeting.sport.app.sport_event;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DeleteEventValidator {

    private static final Logger logger = LoggerFactory.getLogger(DeleteEventValidator.class);


    void validate(Long userId, SportEvent sportEvent){
        try {
            validateOwner(userId,sportEvent);
            validateDeleteTime(sportEvent);
        } catch (Exception e) {
            logger.error("Delete sport event validation failed for user: " + userId + " and event: " + sportEvent.getId(), e);
            throw new RuntimeException("Delete sport event validation failed");
        }
    }

    private void validateDeleteTime(SportEvent sportEvent){
        sportEvent.checkTimeDeleteEvent();
    }

    private void validateOwner(Long userId, SportEvent sportEvent){
        sportEvent.checkOwner(userId);
    }
}
