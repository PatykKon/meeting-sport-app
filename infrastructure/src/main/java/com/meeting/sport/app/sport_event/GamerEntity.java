package com.meeting.sport.app.sport_event;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "GAMER")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GamerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    @ManyToMany(mappedBy = "gamerEntities",cascade = CascadeType.ALL)
    private List<SportEventEntity> sportEventEntities = new ArrayList<>();
}
