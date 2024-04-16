package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/management/user")
@PreAuthorize("hasRole('ADMIN_ROLE')")
public class UserQueryAPI {

    private final UserQuery userQuery;

    @GetMapping
    public UserResponse getUser(){
        return userQuery.getUserResponse();
    }
}
