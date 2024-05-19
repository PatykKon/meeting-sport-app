package com.meeting.sport.app.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "GAME_USER")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int age;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "userEntity",fetch = FetchType.EAGER)
    private List<TokenEntity> tokenEntities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role.getAuth());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
