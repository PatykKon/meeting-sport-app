package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import com.meeting.sport.app.user.dto.UserResponse;

interface UserService {

    UserDTO getLoggedUser(String userEmail);
    User getLoggedUser(Long id);

    UserDTO getUserDTOByEmail(String email);

    UserDTO createUser(RegisterRequest request,String encryptedPassword);
}
