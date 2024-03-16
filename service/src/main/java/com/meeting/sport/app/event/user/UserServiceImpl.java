package com.meeting.sport.app.event.user;

import com.meeting.sport.app.user.User;
import com.meeting.sport.app.user.UserMapper;
import com.meeting.sport.app.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getTestUser() {
       return userMapper.DTOToModel(userRepository.findById(1));
    }
}
