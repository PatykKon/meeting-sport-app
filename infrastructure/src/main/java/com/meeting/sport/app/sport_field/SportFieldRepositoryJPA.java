package com.meeting.sport.app.sport_field;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface SportFieldRepositoryJPA extends JpaRepository<SportFieldEntity, Long> {

}
