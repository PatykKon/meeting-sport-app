package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name = "SPORT_EVENT")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SportEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int players;
    private int minAge;
    @ManyToOne
    @JoinColumn(name = "sport_field_entity_id")
    private SportFieldEntity sportFieldEntity;
}
