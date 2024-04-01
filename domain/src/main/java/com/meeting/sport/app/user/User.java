package com.meeting.sport.app.user;


import com.meeting.sport.app.sport_event.EventRole;

import java.util.List;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int age;
    private List<EventRole> eventRoles;
    private Role role;
    private List<Token> tokens;

    public User(Long id, String firstname, String lastname, String email, String password, int age, List<EventRole> eventRoles, Role role, List<Token> tokens) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.eventRoles = eventRoles;
        this.role = role;
        this.tokens = tokens;
    }

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
