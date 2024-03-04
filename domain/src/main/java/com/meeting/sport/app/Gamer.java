package com.meeting.sport.app;

import com.meeting.sport.app.sport_event.SportEvent;
import lombok.Getter;

import java.util.List;

@Getter
public class Gamer {

    private Long id;
    private final int age;
    private List<SportEvent> events;

    public Gamer(int age) {
        this.age = age;
    }

    public Gamer(int age, List<SportEvent> events) {
        this.age = age;
        this.events = events;
    }
}
