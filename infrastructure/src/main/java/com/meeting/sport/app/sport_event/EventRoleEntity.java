package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "EVENT_ROLE")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GameRole gameRole;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "sport_event_entity_id")
    SportEventEntity sportEventEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamer_id")
    private UserEntity userEntity;

}
