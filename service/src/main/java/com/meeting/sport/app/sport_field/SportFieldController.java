package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/sport-field")
class SportFieldController {

    private final SportFieldService sportFieldService;

    @PostMapping
    void addSportField(@RequestBody SportFieldRequest sportFieldRequest){
        sportFieldService.addSportField(sportFieldRequest);
    }
}
