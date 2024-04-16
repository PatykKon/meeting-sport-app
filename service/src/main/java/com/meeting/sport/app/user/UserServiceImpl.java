package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getLoggedUser(String email){

        return userMapper.DTOToModel(userRepository.findUserByEmail(email));
    }

    @Override
    public User getLoggedUser(Long id) {
        return userMapper.DTOToModel(userRepository.findById(id));
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public UserDTO createUser(RegisterRequest request){
        UserDTO user = UserDTO.builder()
                .firstname(request.firstName())
                .lastname(request.lastName())
                .age(request.age())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        return userRepository.saveUser(user);
    }
}
