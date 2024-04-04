package com.meeting.sport.app.sport_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EventRoleRepositoryJPA extends JpaRepository<EventRoleEntity, Long> {
    @Query("SELECT er FROM EventRoleEntity er WHERE er.sportEventEntity.id = :eventId AND er.gameRole = :gameRole AND er.isAvailable = true")
    List<EventRoleEntity> findBySportEventEntityIdAndGameRoleAndIsAvailableTrue(long eventId, GameRole gameRole);

    List<EventRoleEntity> getEventRoleEntitiesByUserId(Long user_id);

    EventRoleEntity getEventRoleEntityByUserIdAndSportEventEntityId(Long userId, Long eventId);

}
