package com.meeting.sport.app.sport_event;

import java.util.ArrayList;
import java.util.List;


public class Gamer {

    private Long id;
    private final int age;
    private List<SportEvent> events;

    public Gamer(int age) {
        this.age = age;
    }

    public Gamer(Long id,int age, List<SportEvent> events) {
        this.id = id;
        this.age = age;
        this.events = events;
    }

    public void addSportEvent(SportEvent sportEvent){
        if(this.events == null){
            this.events = new ArrayList<>();
        }
        this.events.add(sportEvent);
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public List<SportEvent> getEvents() {
        return events;
    }
}
