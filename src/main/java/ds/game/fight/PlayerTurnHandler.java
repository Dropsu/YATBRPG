package ds.game.fight;

import ds.game.abillities.basic.Source;
import ds.game.entities.basic.Mage;
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
    private FightLogger fightLogger;

    @Autowired
    public PlayerTurnHandler(Session session, AbilityHandler abilityHandler, FightLogger fightLogger) {
        this.session = session;
        this.abilityHandler = abilityHandler;
        this.fightLogger = fightLogger;
    }

    public Fight processPlayersTurn(Source sourceENUM, String abilityName){
        applyEveryTurnEquipmentEffects(session.getFight().getMage());
            abilityHandler.handleAbility(sourceENUM,abilityName);
        if(isPlayerLosingHealthDueToLowCondition()){
            int damage = dealDamageForLowCondition();
            fightLogger.addToLog(session.getFight().getMage().getName()+" has taken "+damage+" damage due to low condition");
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

    private void applyEveryTurnEquipmentEffects(Mage fightMage) {
        if(fightMage.getEquipment()!=null){
            if(fightMage.getEquipment().getWeapon()!= null){
                fightMage.getEquipment().getWeapon().everyTurnEffect(fightMage);
            }
            if(fightMage.getEquipment().getArmor()!= null){
                fightMage.getEquipment().getArmor().everyTurnEffect(fightMage);
            }
            if(fightMage.getEquipment().getLeftHandRing()!= null){
                fightMage.getEquipment().getLeftHandRing().everyTurnEffect(fightMage);
            }
            if(fightMage.getEquipment().getRightHandRing()!= null){
                fightMage.getEquipment().getRightHandRing().everyTurnEffect(fightMage);
            }
        }
    }
}
