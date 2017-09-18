package ds.game.fight;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 16.09.2017.
 */
@Service
public class FightPreparator {

    private Session session;
    private RandomOpponentService randomOpponentService;

    @Autowired
    public FightPreparator(Session session, RandomOpponentService randomOpponentService) {
        this.session = session;
        this.randomOpponentService = randomOpponentService;
    }

    Fight prepareFight(){
        if(!isActiveFightInSession()) {
            AbstractEntity opponent = getRandomOpponentForMageLevel();
            Mage fightMage = new Mage(session.getMage());
            Fight fight = new Fight(fightMage, opponent);
            applyEquipmentEffects(fightMage);
            setNewFightToSession(fight);
        }
        return session.getFight();
    }

    private void setNewFightToSession(Fight fight) {
        session.setFight(fight);
    }

    private void applyEquipmentEffects(Mage fightMage) {
        if(fightMage.getEquipment()!=null){
            if(fightMage.getEquipment().getWeapon()!= null){
                fightMage.getEquipment().getWeapon().battlePersistentEffect(fightMage);
            }
            if(fightMage.getEquipment().getArmor()!= null){
                fightMage.getEquipment().getArmor().battlePersistentEffect(fightMage);
            }
            if(fightMage.getEquipment().getLeftHandRing()!= null){
                fightMage.getEquipment().getLeftHandRing().battlePersistentEffect(fightMage);
            }
            if(fightMage.getEquipment().getRightHandRing()!= null){
                fightMage.getEquipment().getRightHandRing().battlePersistentEffect(fightMage);
            }
        }
    }

    private AbstractEntity getRandomOpponentForMageLevel() {
        int mageLevel = session.getMage().getLevel();
        return randomOpponentService.getRandomOpponentForLevel(mageLevel);
    }

    private boolean isActiveFightInSession() {
        return session.getFight() != null;
    }
}
