package com.meeting.sport.app.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    public UserDTO findById(long id);
}
