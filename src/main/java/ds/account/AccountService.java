package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 21.08.2017.
 */

@Service
public class AccountService {


    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void registerAccount(Account account) {
        repository.save(account);
    }
}
