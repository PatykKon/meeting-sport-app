package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryImpl(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public UserDTO findById(long id) {
        return UserMapper.entityToDTO(userRepositoryJPA.findById(id).orElseThrow());
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return UserMapper.entityToDTO(userRepositoryJPA.findByEmail(email).orElseThrow());
    }

    @Override
    public UserDTO saveUser(User user) {
        UserEntity entity = UserMapper.modelToEntity(user);
        UserEntity saveUser = userRepositoryJPA.save(entity);
        return UserMapper.entityToDTO(saveUser);
    }
}
