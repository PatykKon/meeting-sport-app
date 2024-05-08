package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class QueryUserServiceImpl implements QueryUserService {

    private final UserRepository userRepository;
    private final UserService userService;



//    public UserResponse getUserResponse(String email){
//        User user = userService.getLoggedUser(email);
//        return UserMapper1.modelToResponse(user);
//    }
    public UserResponse getUserResponse(Long id){
        User user = userService.getLoggedUser(id);
        return UserMapper.modelToResponse(user);
    }
}
