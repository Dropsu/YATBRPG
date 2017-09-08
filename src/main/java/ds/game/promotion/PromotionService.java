package ds.game.promotion;

import ds.config.Session;
import ds.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 02.09.2017.
 */

@Service
public class PromotionService {

    private Session session;
    private int abilitiesPointsPerLevel = 4;
    private int [] experienceTable = new int[20];

    @Autowired
    public PromotionService(Session session) {
        this.session = session;
        for (int level = 0; level < 20 ; level++) {
            experienceTable[level]=level*100;
        }
    }

    public void grantLevelAndAbilitiesPointsIfEnoughExp (){
        while(session.mage.experiencePoints>=experienceTable[session.mage.level+1]){
            session.mage.level++;
            session.mage.abilitiesPointsToSpare+=abilitiesPointsPerLevel;
        }
    }

    private void raiseMaxHealthPoints () {
        int basicHealthPointsIncreasePerLevel = 10;
        int additionalHealthPointsPerConditionPoint = 3;
        session.mage.healthPoints+=basicHealthPointsIncreasePerLevel
                +(session.mage.condition-10)*additionalHealthPointsPerConditionPoint;
    }

    private void raiseMaxManaPoints () {
        int basicManaPointsIncreasePerLevel = 10;
        int additionalManaPointsPerConcentrationPoint = 7;
        session.mage.manaPoints+=basicManaPointsIncreasePerLevel
                +(session.mage.concentration-10)*additionalManaPointsPerConcentrationPoint;
    }

    public Message receivePoints(DistributedPoints distributedPoints){

        if(correctNumberOfPointsIsAdded(distributedPoints)){
            distributePoints(distributedPoints);
            raiseMaxHealthPoints();
            raiseMaxManaPoints();
            return new Message("Points spared");
        } else
        return new Message("Error during Point Sparing");
    }

    private void distributePoints(DistributedPoints distributedPoints) {
        session.mage.strength=distributedPoints.getStrength();
        session.mage.condition=distributedPoints.getCondition();
        session.mage.agility=distributedPoints.getAgility();
        session.mage.accuracy=distributedPoints.getAccuracy();
        session.mage.concentration=distributedPoints.getConcentration();
        session.mage.abilitiesPointsToSpare=0;
    }

    private boolean correctNumberOfPointsIsAdded(DistributedPoints distributedPoints){
        if(distributedPoints.sumAbilitiesPoints()==session.mage.abilitiesPointsToSpare) {
            return false;
        }
        else return true;
    }
}
