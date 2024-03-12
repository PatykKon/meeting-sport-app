package com.meeting.sport.app.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<UserEntity,Long> {
}
