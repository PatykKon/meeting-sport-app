package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/user")

public class UserQueryAPI {

    private final UserQuery userQuery;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId){
        return userQuery.getUserResponse(userId);
    }
}
