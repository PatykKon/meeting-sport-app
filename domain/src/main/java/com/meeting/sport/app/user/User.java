package com.meeting.sport.app.user;

import java.util.ArrayList;
import java.util.List;

class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int age;
    private String role;
    private List<Token> tokens;

    User(Long id, String firstname, String lastname, String email, String password, int age, String role, List<Token> tokens) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
        this.tokens = tokens;
    }

    static User createUser(String firstname, String lastname, int age, String email, String password, String userRole) {

        return new User(
                null,
                firstname,
                lastname,
                email,
                password,
                age,
                userRole,
                new ArrayList<>());
    }


    Long getId() {
        return id;
    }

    String getFirstname() {
        return firstname;
    }

    String getLastname() {
        return lastname;
    }

   String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    int getAge() {
        return age;
    }

    String getRole() {
        return role;
    }

    List<Token> getTokens() {
        return tokens;
    }
}
