package com.meeting.sport.app.sport_event;

import java.util.List;

public class GameUserMapper {

    public static GameUserEntity toEntity(GameUser gameUser) {

        return GameUserEntity.builder()
                .id(gameUser.getId())
                .isAvailable(gameUser.isAvailable())
                .gameRole(gameUser.getGameRole())
                .build();

    }
    public static List<GameUserEntity> toEntityList(List<GameUser> gameUsers) {

        return gameUsers.stream().map(GameUserMapper::toEntity).toList();
    }

    public static GameUserResponse toResponse(GameUserEntity entity) {
        return GameUserResponse.builder()
                .gameRole(entity.getGameRole())
                .id(entity.getId())
                .isAvailable(entity.isAvailable())
                .build();
    }

    public static List<GameUserResponse> toResponseList(List<GameUserEntity> gameUserEntities) {
        return gameUserEntities.stream().map(GameUserMapper::toResponse).toList();
    }
}

