package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.EventRoleEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "GAME_USER")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    @OneToMany(mappedBy = "userEntity")
    private List<EventRoleEntity> eventRoleEntities = new ArrayList<>();
}
