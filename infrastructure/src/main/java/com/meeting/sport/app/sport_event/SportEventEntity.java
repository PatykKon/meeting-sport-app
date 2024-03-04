package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.gamer.GamerEntity;
import com.meeting.sport.app.sport_field.SportFieldEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "SPORT_EVENT")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class SportEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int players;
    private int minAge;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer gameTime;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sportEventEntity",cascade = CascadeType.ALL)
    private List<GameUserEntity> gameUsers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "sport_field_entity_id")
    private SportFieldEntity sportFieldEntity;
    @ManyToMany(mappedBy = "sportEventEntities",cascade = CascadeType.ALL)
    private List<GamerEntity> gamers = new ArrayList<>();
}
