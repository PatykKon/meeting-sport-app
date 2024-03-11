package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldEntity;
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
    @OneToMany(mappedBy = "sportEventEntity", cascade = CascadeType.ALL)
    private List<GameUserEntity> gameUsersEntities = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "sport_field_entity_id")
    private SportFieldEntity sportField;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "GAMER_SPORT_EVENT",
            joinColumns = {@JoinColumn(name = "sport_event_id")},
            inverseJoinColumns = {@JoinColumn(name = "gamer_id")}
    )
    private List<GamerEntity> gamerEntities = new ArrayList<>();

}
