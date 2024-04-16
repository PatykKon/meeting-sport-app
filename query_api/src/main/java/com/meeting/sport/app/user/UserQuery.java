package com.meeting.sport.app.user;

import com.meeting.sport.app.audtiting.ApplicationAuditAware;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserQuery {

    private final QueryUserService queryUserService;
    private final ApplicationAuditAware applicationAuditAware;


    public UserResponse getUserResponse(){
        Optional<Long> userId = applicationAuditAware.getCurrentAuditor();

        return userId.map(queryUserService::getUserResponse)
                .orElseThrow(() -> new IllegalStateException("Nie można uzyskać identyfikatora użytkownika"));
    }

}
