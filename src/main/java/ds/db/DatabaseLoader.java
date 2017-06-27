package ds.db;

import ds.account.Account;
import ds.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Damian on 27.06.2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AccountRepository repository;

    @Autowired
    public DatabaseLoader(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Account("Damian", "somePassword"));
    }
}
