package ds.game.promotion;

import ds.config.Session;
import ds.game.entities.Mage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by Damian on 01.09.2017.
 */
@Controller
public class PromotionController {

    @Autowired
    private Session session;

    @RequestMapping("/promotion")
    public String promotionPage(){
        session.mage.concentration+=5;
        return "promotion";
    }

    @MessageMapping("/send-promotion-data")
    public Mage sendPromotionData (HttpSession session) {
        return (Mage) session.getAttribute("hero");
    }
}
