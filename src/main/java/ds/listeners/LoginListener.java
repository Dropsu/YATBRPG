package ds.listeners;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.config.Session;
import ds.game.entities.Mage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class LoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {


    AccountRepository accountRepository;
    Session session;

    @Autowired
    public LoginListener(AccountRepository accountRepository, Session session) {
        this.accountRepository = accountRepository;
        this.session = session;
    }

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
    {
        Mage playersHero = getPlayersHeroForLoggedUser(event);
        AddPlayerHeroToSession(playersHero);
    }

    private Mage getPlayersHeroForLoggedUser(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        Account playersAccount = accountRepository.findByusername(userDetails.getUsername()).get(0);
        return playersAccount.getPlayersHero();
    }

    private void AddPlayerHeroToSession(Mage playersHero) {
        session.mage = playersHero;
    }


}