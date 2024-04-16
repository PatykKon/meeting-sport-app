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
class EventRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private GameRole gameRole;
    private boolean isAvailable;
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "sport_event_entity_id")
    SportEventEntity sportEventEntity;

}
