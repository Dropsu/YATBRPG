package ds.account;

import ds.game.hero.MageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 21.08.2017.
 */

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void registerAccount(Account account) {
        account.addHero(account.getUsername()); //TODO: move it somewhere else, change hero creation
        accountRepository.save(account);
    }
}
