package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class SportEvent {

    private Long id;
    private Title title;
    private Description description;
    private TeamSize teamSize;
    private RequiredAge requiredAge;
    private SportField sportField;
    private List<EventRole> eventRoles;
    private EventTime eventTime;
    private List<User> users;


    public SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, SportField sportField, List<EventRole> eventRoles, EventTime eventTime, List<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.sportField = sportField;
        this.eventRoles = eventRoles;
        this.eventTime = eventTime;
        this.users = users;
    }

    private SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, List<EventRole> eventRoles, EventTime eventTime, List<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.eventRoles = eventRoles;
        this.eventTime = eventTime;
        this.users = users;
    }

    public static SportEvent create(String title,
                                    String description,
                                    int players,
                                    int minAge,
                                    LocalDateTime startEvent,
                                    Integer gameTime) {

        Title gameTitle = new Title(title);
        Description gameDescription = new Description(description);
        TeamSize gameTeamSize = new TeamSize(players);
        RequiredAge requiredAge = new RequiredAge(minAge);
        EventTime eventTime = new EventTime(gameTime, startEvent);
        List<User> userList = new ArrayList<>();
        List<EventRole> eventRoleList = new ArrayList<>();


        return new SportEvent(null, gameTitle, gameDescription, gameTeamSize, requiredAge, eventRoleList, eventTime, userList);
    }

    public void addGameUser(EventRole eventRole) {
        if (eventRoles == null) {
            eventRoles = new ArrayList<>();
        }
        this.eventRoles.add(eventRole);
        eventRole.addSportEvent(this);

    }

    public void joinToEvent(User user, GameRole gameRole) {

        EventRole eventRole = submitRole(gameRole);
        eventRole.changeAvailability();
        eventRole.addGamer(user);
        checkGamerAge(user);
        addGamer(user);


    }

    public void submitSportField(SportField sportField) {
        this.sportField = sportField;
    }

    private EventRole submitRole(GameRole gameRole) {
        return eventRoles.stream()
                .filter(gameUser -> gameUser.getGameRole() == gameRole && gameUser.isAvailable() == true)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));

    }

    private void checkGamerAge(User user) {
        this.requiredAge.isUserAgeCorrect(user.getAge());
    }


    private void addGamer(User user) {
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        this.users.add(user);
        user.addSportEvent(this);
    }

    public Long getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public TeamSize getTeamSize() {
        return teamSize;
    }

    public RequiredAge getRequiredAge() {
        return requiredAge;
    }

    public SportField getSportField() {
        return sportField;
    }

    public List<EventRole> getGameUsers() {
        return eventRoles;
    }

    public EventTime getEventTime() {
        return eventTime;
    }

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

    public List<User> getUsers() {
        return users;
    }
}
