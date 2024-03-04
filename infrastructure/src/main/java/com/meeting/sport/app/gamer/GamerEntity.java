package com.meeting.sport.app.gamer;

import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "GAMER")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class GamerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "GAMER_SPORT_EVENT",
            joinColumns = { @JoinColumn(name = "gamer_id") },
            inverseJoinColumns = { @JoinColumn(name = "sport_event_id") }
    )
    private List<SportEventEntity> sportEventEntities = new ArrayList<>();
}
