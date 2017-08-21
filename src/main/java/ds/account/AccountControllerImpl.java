package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Damian on 21.08.2017.
 */
@Controller
@RequestMapping("/account/register")
public class AccountControllerImpl implements AccountController {

    private AccountService accountService;

    @Autowired
    public AccountControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerAccount(Account account) {
        accountService.registerAccount(account);
        return "home";
    }
}
