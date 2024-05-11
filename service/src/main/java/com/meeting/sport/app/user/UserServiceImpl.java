package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getLoggedUser(String email) {

        return UserMapper.DTOToModel(userRepository.findUserByEmail(email));
    }

    @Override
    public User getLoggedUser(Long id) {
        return UserMapper.DTOToModel(userRepository.findById(id));
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserDTO createUser(RegisterRequest request) {

        String encodedPassword = passwordEncoder.encode(request.password());

        User user = User.createUser(
                request.firstName(),
                request.lastName(),
                request.age(),
                request.email(),
                encodedPassword
        );

        return userRepository.saveUser(user);
    }
}
