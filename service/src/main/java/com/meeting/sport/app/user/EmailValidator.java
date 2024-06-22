package com.meeting.sport.app.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
class EmailValidator {

    private final static String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final UserRepository userRepository;

    public void validate(String email) {
        checkEmailExist(email);
        checkEmailFormat(email);
    }

    private void checkEmailExist(String email) {
        boolean emailExist = userRepository.existByEmail(email);
        if (emailExist) {
            throw new RuntimeException("this email: " + email + " is used!");
        }
    }

    private void checkEmailFormat(String emailAddress) {

        Pattern regexPattern = Pattern.compile(REGEX);
        Matcher regMatcher = regexPattern.matcher(emailAddress);
        if (!regMatcher.matches()) {
            throw new RuntimeException("Invalid Email Address");
        }
    }
}
