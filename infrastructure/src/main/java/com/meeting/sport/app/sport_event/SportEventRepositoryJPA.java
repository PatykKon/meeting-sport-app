package com.meeting.sport.app.sport_event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SportEventRepositoryJPA extends JpaRepository<SportEventEntity, Long> {

    List<SportEventEntity> findAllBySportEventStatus(SportEventStatus sportEventStatus);

}
