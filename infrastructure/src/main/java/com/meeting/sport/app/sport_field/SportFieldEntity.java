package com.meeting.sport.app.sport_field;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "SPORT_FIELD")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
}


