package com.meeting.sport.app.user;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AuthorityMapper {

    @Named("mapToAuthorities")
    public default List<SimpleGrantedAuthority> mapToAuthorities(SimpleGrantedAuthority authority) {
        return Collections.singletonList(authority);
    }
}
