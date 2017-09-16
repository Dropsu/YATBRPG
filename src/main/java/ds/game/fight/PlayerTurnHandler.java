package ds.game.fight;

import ds.game.abillities.basic.Source;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 16.09.2017.
 */

@Service
public class PlayerTurnHandler {

    private Session session;
    private AbilityHandler abilityHandler;

    @Autowired
    public PlayerTurnHandler(Session session, AbilityHandler abilityHandler) {
        this.session = session;
        this.abilityHandler = abilityHandler;
    }

    public Fight processPlayersTurn(Source sourceENUM, String abilityName){
        applyEveryTurnRingsEffects();
        abilityHandler.handleAbility(sourceENUM,abilityName);

        return session.getFight();
    }

    private void applyEveryTurnRingsEffects() {
        if(session.getFight().getMage().getEquipment() !=null && session.getFight().getMage().getEquipment().getLeftHandRing()!=null){
            session.getFight().getMage().getEquipment().getLeftHandRing().everyTurnEffect(session.getFight().getMage());
        }
        if(session.getFight().getMage().getEquipment() !=null && session.getFight().getMage().getEquipment().getRightHandRing()!=null){
            session.getFight().getMage().getEquipment().getRightHandRing().everyTurnEffect(session.getFight().getMage());
        }
    }
}
