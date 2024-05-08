package com.meeting.sport.app.user;


import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int age;
    private Role role;
    private List<Token> tokens;

    public User(Long id, String firstname, String lastname, String email, String password, int age, Role role, List<Token> tokens) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
        this.tokens = tokens;
    }

    static User createUser(String firstname, String lastname, int age, String email, String password) {
        return new User(
                null,
                firstname,
                lastname,
                email,
                password,
                age,
                Role.USER,
                new ArrayList<>());
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
