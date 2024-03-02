package com.meeting.sport.app.sport_event;

class RequiredAge {

    private final int Age;

    RequiredAge(int age) {
        Age = checkAge(age);
    }

    private int checkAge(int age) {
        if (age < 0) {
            throw new RuntimeException("age can not be less than 0");
        }
        return age;
    }

    int getAge() {
        return Age;
    }

}
