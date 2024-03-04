package com.meeting.sport.app.sport_event;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "GAME_USER")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class GameUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GameRole gameRole;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "sport_event_entity_id")
    SportEventEntity sportEventEntity;
}
