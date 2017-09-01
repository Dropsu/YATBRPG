package ds.account;

import ds.game.hero.MageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 21.08.2017.
 */

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository repository;

    @Autowired
    private MageRepository mageRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    public void registerAccount(Account account) {
        account.addHero();
        mageRepository.save(account.getPlayersHero());
        repository.save(account);
    }
}
