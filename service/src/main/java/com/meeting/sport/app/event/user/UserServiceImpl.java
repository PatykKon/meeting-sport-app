package com.meeting.sport.app.event.user;

import com.meeting.sport.app.user.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User getLoggedUser(String email){

        return userMapper.DTOToModel(userRepository.findUserByEmail(email));
    }

}
