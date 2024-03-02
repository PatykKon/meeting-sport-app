package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEventEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "SPORT_FIELD")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
public class SportFieldEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private FieldSpace fieldSpace;
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;
    @OneToMany(mappedBy = "sportFieldEntity", cascade = CascadeType.ALL)
    private List<SportEventEntity> sportEventEntities = new ArrayList<>();
}
