package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.RegisterRequest;
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
        return UserMapper1.entityToDTO(userRepositoryJPA.findById(id).orElseThrow());
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return UserMapper1.entityToDTO(userRepositoryJPA.findByEmail(email).orElseThrow());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper1.DTOToModel(userDTO);
        UserEntity entity = UserMapper1.modelToEntity(user);
        UserEntity saveUser = userRepositoryJPA.save(entity);
        return UserMapper1.entityToDTO(saveUser);
    }
}
