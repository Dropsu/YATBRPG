package ds.game.fight;

import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 16.09.2017.
 */

@Service
public class FightFinisher {

    private Session session;
    private FightLogger fightLogger;

    @Autowired
    public FightFinisher(Session session, FightLogger fightLogger) {
        this.session = session;
        this.fightLogger = fightLogger;
    }

    public void finishFight(){
        boolean isPlayerAWinner = session.getFight().getMage().getHealthPoints() > 0;
        if(isPlayerAWinner){
            rewardHero();
        }
        cleanUpAfterFight();
    }

    private void cleanUpAfterFight (){
        session.setFight(null);
    }

    private void rewardHero (){
        int experienceForOpponent = getExperienceForOpponent();
        int goldForOpponent = getGoldForOpponent();
        session.getMage().setExperiencePoints(session.getMage().getExperiencePoints() + experienceForOpponent);
        session.getMage().getEquipment().setGold(session.getMage().getEquipment().getGold()+goldForOpponent);
    }

    private int getExperienceForOpponent() {
        return session.getFight().getOpponent().getExperienceForDefeating();
    }

    private int getGoldForOpponent() {
        return session.getFight().getOpponent().getGoldForDefeating();
    }
}
