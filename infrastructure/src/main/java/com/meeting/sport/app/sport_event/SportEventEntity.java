package com.meeting.sport.app.sport_event;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "SPORT_EVENT")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
class SportEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int players;
    private int minPlayers;
    private int minAge;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer gameTime;
    private Long ownerId;
    @Enumerated(EnumType.STRING)
    private SportEventStatus sportEventStatus;
    @OneToMany(mappedBy = "sportEventEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EventRoleEntity> eventRoleEntities = new ArrayList<>();

    private Long sportFieldId;

}
