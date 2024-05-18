package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SportFieldQuery {

    private final SportFieldRepository sportFieldRepository;

    public List<SportFieldResponse> getSportFields() {
        return sportFieldRepository.findAllEntity().stream().map(SportFieldMapper::entityToResponse).toList();
    }

    public SportFieldResponse getSportFieldByEvent(long sportFieldId) {


        SportFieldEntity entity = sportFieldRepository.findById(sportFieldId);

        return SportFieldMapper.entityToResponse(entity);
    }
}
