package com.meeting.sport.app.user;

import org.springframework.stereotype.Repository;

@Repository
class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findById(long id) {
        return userMapper.entityToDTO(userRepositoryJPA.findById(id).orElseThrow());
    }
}
