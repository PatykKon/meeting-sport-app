package com.meeting.sport.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
