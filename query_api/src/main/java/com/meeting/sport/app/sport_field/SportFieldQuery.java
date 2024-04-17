package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.dto.SportFieldResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SportFieldQuery {

    private final SportFieldRepository sportFieldRepository;

    public List<SportFieldResponse> getSportFields() {
        return sportFieldRepository.findAllEntity().stream().map(SportFieldMapper1::entityToResponse).toList();
    }

    public SportFieldResponse getSportFieldByEvent(long sportFieldId) {


        SportFieldEntity entity = sportFieldRepository.findEntityById(sportFieldId);

        return SportFieldMapper1.entityToResponse(entity);
    }
}