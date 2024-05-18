package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_field.command.AddSportFieldCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-field")
class SportFieldAPI {

    private final CreateSportFieldHandler createSportFieldHandler;

    @PostMapping("/add")
    public Long addSportField(@RequestBody AddSportFieldCommand command) {
        return createSportFieldHandler.handle(command);
    }
}
