package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
class UserQuery {

    private final QueryUserService queryUserService;

    public UserResponse getUserResponse(Long userId) {
        return queryUserService.getUserResponse(userId);
    }
}
