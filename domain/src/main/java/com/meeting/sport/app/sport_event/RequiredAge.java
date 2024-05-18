package com.meeting.sport.app.sport_event;

import java.util.Objects;

class RequiredAge {

    private final static int MIN_AGE = 0;

    private final int age;

    RequiredAge(int age) {
        this.age = checkAge(age);
    }

    private int checkAge(int age) {
        if (age < MIN_AGE) {
            throw new RuntimeException("age can not be less than 0");
        }
        return age;
    }

    void validateAge(int userAge){
        if (age > userAge) {
            throw new RuntimeException("user is too young to join this sport event");
        }
    }

    int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequiredAge that = (RequiredAge) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
