package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 21.08.2017.
 */

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;
    private MageCreator mageCreator;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, MageCreator mageCreator) {
        this.accountRepository = accountRepository;
        this.mageCreator = mageCreator;
    }

    public String registerAccount(Account account) {
        account.setPlayersHero(mageCreator.buildMageForNewAccount(account.getUsername()));
        try{
            accountRepository.save(account);
        } catch (Exception e) {
            return "Error during account registration";
        }
        return "Account Registered";
    }
}
