package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 21.08.2017.
 */
@Controller
@RequestMapping("/account/register")
public class AccountControllerImpl implements AccountContoller {

    private AccountService accountService;

    @Autowired
    public AccountControllerImpl(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String registerAccount(Account account) {
        String message = accountService.registerAccount(account);
        return message;
    }
}
