package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.EventRole;
import com.meeting.sport.app.sport_event.SportEvent;

import java.util.ArrayList;
import java.util.List;


public class User {

    private Long id;
    private int age;
    private List<SportEvent> events;
    private List<EventRole> eventRoles;

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public User(Long id, int age, List<SportEvent> events, List<EventRole> eventRoles) {
        this.id = id;
        this.age = age;
        this.events = events;
        this.eventRoles = eventRoles;
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
