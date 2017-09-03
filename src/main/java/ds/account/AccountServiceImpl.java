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


    private MageRepository mageRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, MageRepository mageRepository) {
        this.accountRepository = accountRepository;
        this.mageRepository = mageRepository;
    }

    public void registerAccount(Account account) {
        account.addHero();
        mageRepository.save(account.getPlayersHero());
        accountRepository.save(account);
    }
}
