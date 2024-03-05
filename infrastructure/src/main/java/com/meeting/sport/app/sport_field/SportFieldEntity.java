package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEventEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "SPORT_FIELD")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Builder
public class SportFieldEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private FieldSpace spaceField;
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;
    private String city;
    private String street;
    private String number;
    @OneToMany(mappedBy = "sportField", cascade = CascadeType.ALL)
    private List<SportEventEntity> sportEvents = new ArrayList<>();
}
