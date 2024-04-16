package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    UserDTO findById(long id);

    UserDTO findUserByEmail(String email);

    UserDTO saveUser(UserDTO userDTO);

}
