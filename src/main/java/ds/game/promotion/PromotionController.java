package ds.game.promotion;

import ds.config.Session;
import ds.game.entities.Mage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;

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

    @RequestMapping("/promotion")
    public String promotionPage(){
        promotionService.grantLevelAndAbilitiesPointsIfEnoughExp();
        return "promotion";
    }

    @RequestMapping(value = "/promotion", method = RequestMethod.POST)
    public String distributePoints(DistributedPoints distributedPoints){
        promotionService.distributePoints(distributedPoints);
        return "promotion";
    }

}
