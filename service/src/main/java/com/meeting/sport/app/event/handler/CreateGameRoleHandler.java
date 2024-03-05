package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateGameRoleCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.GameUser;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CreateGameRoleHandler implements CommandHandler<CreateGameRoleCommand> {

    private final SportEventRepository sportEventRepository;

    @Autowired
    CreateGameRoleHandler(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public void handle(CreateGameRoleCommand command) {

        SportEvent sportEvent= sportEventRepository.findById(command.sportEventId());

        List<GameUser> gameUsers = GameUser.crateGameUsers(command.gameRoles());

        gameUsers.forEach(sportEvent::addGameUser);

        sportEventRepository.save(sportEvent);
    }
}
