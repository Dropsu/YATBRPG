package ds.listeners;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.game.entities.basic.PlayersHero;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

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
        PlayersHero playersHero = getPlayersHeroForLoggedUser(event);
        AddPlayerHeroToSession(playersHero);
    }

    private PlayersHero getPlayersHeroForLoggedUser(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        Account playersAccount = accountRepository.findByusername(userDetails.getUsername()).get(0);
        return playersAccount.getPlayersHero();
    }

    private void AddPlayerHeroToSession(PlayersHero playersHero) {
        session.setMage(playersHero);
    }


}