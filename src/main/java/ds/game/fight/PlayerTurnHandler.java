package ds.game.fight;

import ds.game.abillities.basic.Source;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Damian on 16.09.2017.
 */

@Service
public class PlayerTurnHandler {

    private Session session;
    private AbilityHandler abilityHandler;
    private FightLogger fightLogger;

    @Autowired
    public PlayerTurnHandler(Session session, AbilityHandler abilityHandler, FightLogger fightLogger) {
        this.session = session;
        this.abilityHandler = abilityHandler;
        this.fightLogger = fightLogger;
    }

    public Fight processPlayersTurn(Source sourceENUM, String abilityName){
        applyEveryTurnRingsEffects();
            abilityHandler.handleAbility(sourceENUM,abilityName);
        if(isPlayerLosingHealthDueToLowCondition()){
            int damage = dealDamageForLowCondition();
            fightLogger.addToLog(session.getFight().getMage().getName()+" has taken "+damage+" due to low condition");
        }

        return session.getFight();
    }

    private boolean isPlayerLosingHealthDueToLowCondition() {
        return session.getFight().getMage().getCondition()<10;
    }

    private int dealDamageForLowCondition() {
        int healthPoints = session.getFight().getMage().getHealthPoints();
        int damage = 10-session.getFight().getMage().getCondition();
        session.getFight().getMage().setHealthPoints(healthPoints-damage);
        return damage;
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
