package ds.game.hero;

import ds.game.entities.Mage;
import ds.game.entities.PlayersHero;
import ds.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Damian on 24.08.2017.
 */
@Controller
public class HeroCreationController {


    @MessageMapping("/create-hero")
    @SendToUser("/queue/notifications")
    public Message createNewHero (PlayersHero playersHero) {

        return new Message("Hero Created!");
    }

}
