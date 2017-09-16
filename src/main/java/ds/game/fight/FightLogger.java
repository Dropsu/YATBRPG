package ds.game.fight;

import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 16.09.2017.
 */
@Service
public class FightLogger {
    private Session session;

    @Autowired
    public FightLogger(Session session) {
        this.session = session;
    }

    public void addToLog(String message){
        session.getFight().getLog().add(message);
    }

}
