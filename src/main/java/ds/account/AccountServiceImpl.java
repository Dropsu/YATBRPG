package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void registerAccount(Account account) {
        account.setPlayersHero(mageCreator.buildMageForNewAccount(account.getUsername()));
        accountRepository.save(account);
    }
}
