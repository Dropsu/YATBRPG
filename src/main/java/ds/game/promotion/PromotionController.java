package ds.game.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Damian on 01.09.2017.
 */
@Controller
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @RequestMapping("/hero")
    public String promotionPage(){
        promotionService.grantLevelAndAbilitiesPointsIfEnoughExp();
        return "hero";
    }

    @RequestMapping(value = "/hero", method = RequestMethod.POST)
    public String distributePoints(DistributedPoints distributedPoints){
        promotionService.receivePoints(distributedPoints);
        return "hero";
    }

}
