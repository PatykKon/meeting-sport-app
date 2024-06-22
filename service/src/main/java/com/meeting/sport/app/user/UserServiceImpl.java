package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailValidator emailValidator;

    @Override
    public UserDTO getLoggedUser(String email) {

        return userRepository.findUserByEmail(email);
    }

    @Override
    public User getLoggedUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserDTO createUser(RegisterRequest request,String encryptedPassword) {

        emailValidator.validate(request.email());

        User user = User.createUser(
                request.firstName(),
                request.lastName(),
                request.age(),
                request.email(),
                encryptedPassword,
                Role.USER.toString()
        );

        return UserMapper.modelToDTO(userRepository.saveUser(user));
    }

}
