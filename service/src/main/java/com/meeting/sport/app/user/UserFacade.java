package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final QueryUserService queryUserService;

    public User getLoggedUser(String userEmail) {
        return userService.getLoggedUser(userEmail);
    }

    public UserResponse getUserResponse(Long userId){
        return queryUserService.getUserResponse(userId);
    }

    public UserDTO getUserByEmail(String email){
        return userService.getUserDTOByEmail(email);
    }


    public UserDTO createUser(RegisterRequest request){
        return userService.createUser(request);
    }
}
