package com.meeting.sport.app.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserDTO findById(long id);

    UserDTO findUserByEmail(String email);
}
