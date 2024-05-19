package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository {

    User findById(long id);

    UserDTO findUserByEmail(String email);

    User saveUser(User user);

    boolean existByEmail(String email);

}
