package ds.game.fight;

import ds.game.abillities.basic.Source;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 05.09.2017.
 */
@Controller
@RequestMapping("/fight")
public class FightController {

    private FightService fightService;
    private Session session;

    @Autowired
    public FightController(FightService fightService, Session session) {
        this.fightService = fightService;
        this.session = session;
    }





    @RequestMapping(method = RequestMethod.GET)
    public String returnFightPageAndPrepareFight (){
        return "fight";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Fight prepareFight(){
        fightService.prepareFight();
        return session.getFight();
    }

    @RequestMapping(value = "/finish", method = RequestMethod.GET)
    public String finishFight (){
        fightService.finishFight();
        return "home";
    }


    @RequestMapping(value = "/next-turn", method = RequestMethod.POST)
    public @ResponseBody Fight  nextTurn (String abilityName){
        fightService.processTurn(Source.MAGE,abilityName);
        return session.getFight();
    }
}
