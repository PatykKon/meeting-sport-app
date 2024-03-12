package com.meeting.sport.app.sport_event;

class RequiredAge {

    private final int age;

    RequiredAge(int age) {
        this.age = checkAge(age);
    }

    private int checkAge(int age) {
        if (age < 0) {
            throw new RuntimeException("age can not be less than 0");
        }
        return age;
    }

    void isUserAgeCorrect(int userAge) {
        if (age < userAge) {
            throw new RuntimeException("user is too young to join this sport event");
        }
    }

    public int getAge() {
        return age;
    }
}
