package ds.home;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.config.Session;
import ds.game.entities.Mage;
import ds.game.hero.MageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Damian on 27.06.2017.
 */
@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
