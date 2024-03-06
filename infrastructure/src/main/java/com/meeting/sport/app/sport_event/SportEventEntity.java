package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "SPORT_EVENT")
@Entity
@NoArgsConstructor
@Getter
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
    private List<GameUserEntity> gameUsersEntities = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "sport_field_entity_id")
    private SportFieldEntity sportField;
    @ManyToMany(mappedBy = "sportEventEntities",cascade = CascadeType.ALL)
    private List<GamerEntity> gamerEntities = new ArrayList<>();

    public SportEventEntity(Long id, String title, String description, int players, int minAge, LocalDateTime startTime, LocalDateTime endTime, Integer gameTime, List<GameUserEntity> gameUsersEntities, SportFieldEntity sportField, List<GamerEntity> gamerEntities) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.players = players;
        this.minAge = minAge;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gameTime = gameTime;
        this.gameUsersEntities = gameUsersEntities;
        this.sportField = sportField;
        this.gamerEntities = gamerEntities;
    }
}
