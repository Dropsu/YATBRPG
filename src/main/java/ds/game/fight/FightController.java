package ds.game.fight;

import ds.game.abillities.Ability;
import ds.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Damian on 05.09.2017.
 */
@Controller
public class FightController {

    private FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @RequestMapping(value = "/fight", method = RequestMethod.GET)
    public String returnFightPageAndPrepareFight (){
        fightService.prepareFight();
        return "fight";
    }

    @MessageMapping(value = "/fight-ability")
    @SendToUser("/queue/notifications")
    public Message  handleAbility (String abilityName){
        fightService.handleAction(abilityName);
        fightService.addToLog(abilityName);
        return new Message("returning "+ abilityName);
    }
}
