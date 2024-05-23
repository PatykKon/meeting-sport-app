package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.exceptions.DescriptionValidationException;

import java.util.Objects;

class Description {

    private final static int MAX_DESCRIPTION = 250;
    private final String value;

    Description(String value) {
        this.value = checkDescription(value);
    }

    private String checkDescription(String description) {
        if (description.length() > MAX_DESCRIPTION) {
            throw new DescriptionValidationException("description is too long");
        }
        if (description.isEmpty() || description == null) {
            throw new DescriptionValidationException("description can bo empty");
        }
        return description;
    }

    String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
