package com.meeting.sport.app.sport_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EventRoleRepositoryJPA extends JpaRepository<EventRoleEntity, Long> {
    @Query("SELECT er FROM EventRoleEntity er WHERE er.sportEventEntity.id = :eventId AND er.gameRole = :gameRole AND er.isAvailable = true")
    List<EventRoleEntity> findBySportEventEntityIdAndGameRoleAndIsAvailableTrue(long eventId, GameRole gameRole);

    @Query("SELECT CASE WHEN COUNT(er) > 0 THEN true ELSE false END FROM EventRoleEntity er WHERE er.userEntity.id = :userId AND er.sportEventEntity.id = :eventId")
    boolean isUserExistInEvent(long eventId, long userId);

    List<EventRoleEntity> getEventRoleEntitiesByUserEntity_Id(Long user_id);

    EventRoleEntity getEventRoleEntityByUserEntityIdAndSportEventEntityId(Long userId,Long eventId);

    List<EventRoleEntity> getEventRoleEntitiesByUserEntityId(Long userId);

}
