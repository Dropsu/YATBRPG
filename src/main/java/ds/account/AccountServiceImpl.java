package ds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 21.08.2017.
 */

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;
    private MageCreator mageCreator;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, MageCreator mageCreator,PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.mageCreator = mageCreator;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerAccount(Account account) {
        account.setPlayersHero(mageCreator.buildMageForNewAccount(account.getUsername()));
        encodePassword(account);
        try{
            accountRepository.save(account);
        } catch (Exception e) {
            return "Error during account registration";
        }
        return "Account Registered";
    }

    private void encodePassword(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
    }
}
