package ds.game.fight;

import ds.game.abillities.basic.Source;
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

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String returnFightPageAndPrepareFight (){
        return "fight";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Fight prepareFight(){
        return fightService.prepareFight();
    }

    @RequestMapping(value = "/finish", method = RequestMethod.GET)
    public String finishFight (){
        fightService.finishFight();
        return "home";
    }


    @RequestMapping(value = "/next-turn", method = RequestMethod.POST)
    public @ResponseBody Fight  nextTurn (String abilityName){
        return fightService.nextTurn(Source.MAGE,abilityName);
    }
}
