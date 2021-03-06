package ds.listeners;

import ds.game.entities.basic.Mage;
import ds.session.Session;
import ds.account.repositories.MageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Damian on 03.09.2017.
 */

@Component
public class SessionListener implements HttpSessionListener {

    @Autowired
    MageRepository mageRepository;

    @Autowired
    Session session;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        mageRepository.save((Mage) session.getMage());
    }
}
