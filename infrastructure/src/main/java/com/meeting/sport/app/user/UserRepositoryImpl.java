package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    UserRepositoryImpl(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public User findById(long id) {
        return UserMapper.entityToModel(userRepositoryJPA.findById(id).orElseThrow());
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return UserMapper.entityToDTO(userRepositoryJPA.findByEmail(email).orElseThrow());
    }

    @Override
    public User saveUser(User user) {
        UserEntity savedUser = userRepositoryJPA.save(UserMapper.modelToEntity(user));
        return UserMapper.entityToModel(savedUser);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepositoryJPA.existsByEmail(email);
    }
}
