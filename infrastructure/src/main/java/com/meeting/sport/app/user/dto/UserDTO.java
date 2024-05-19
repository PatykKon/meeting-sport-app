package com.meeting.sport.app.user.dto;

import com.meeting.sport.app.user.Role;
import lombok.Builder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
@Builder
public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        String password,
        int age,
        Role role,
        List<TokenDTO> tokenDTOS,
        List<SimpleGrantedAuthority> authorities
) {
}
