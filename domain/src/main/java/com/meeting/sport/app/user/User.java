package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.EventRole;

import java.util.List;

public class User {

    private Long id;

    private String name;

    private int age;
    private List<EventRole> eventRoles;

    public User(Long id, String name, int age, List<EventRole> eventRoles) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.eventRoles = eventRoles;
    }

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
