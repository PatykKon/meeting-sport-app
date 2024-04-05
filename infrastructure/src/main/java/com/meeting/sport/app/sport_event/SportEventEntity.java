package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.beans.ConstructorProperties;
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
    private Long ownerId;
    @OneToMany(mappedBy = "sportEventEntity", cascade = CascadeType.ALL)
    private List<EventRoleEntity> eventRoleEntities = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "sport_field_id")
    private SportFieldEntity sportFieldEntity;

}
