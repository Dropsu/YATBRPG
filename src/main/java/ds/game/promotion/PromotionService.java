package ds.game.promotion;

import ds.session.Session;
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
            experienceTable[level]=level*(level-1)*100;
            experienceTable[1]=0;
        }
    }

    public void grantLevelAndAbilitiesPointsIfEnoughExp (){
        while(session.getMage().getExperiencePoints() >=experienceTable[session.getMage().getLevel() +1]){
            session.getMage().setLevel(session.getMage().getLevel() + 1);
            session.getMage().setAbilitiesPointsToSpare(session.getMage().getAbilitiesPointsToSpare() + abilitiesPointsPerLevel);
        }
    }

    private void raiseMaxHealthPoints () {
        int basicHealthPointsIncreasePerLevel = 10;
        int additionalHealthPointsPerConditionPoint = 3;
        session.getMage().setHealthPoints(session.getMage().getHealthPoints() + basicHealthPointsIncreasePerLevel
                +(session.getMage().getCondition() -10)*additionalHealthPointsPerConditionPoint);
    }

    private void raiseMaxManaPoints () {
        int basicManaPointsIncreasePerLevel = 15;
        int additionalManaPointsPerConcentrationPoint = 5;
        session.getMage().setManaPoints(session.getMage().getManaPoints() + basicManaPointsIncreasePerLevel
                +(session.getMage().getConcentration() -10)*additionalManaPointsPerConcentrationPoint);
    }

    public void receivePoints(DistributedPoints distributedPoints){

        if(isCorrectNumberOfPointsAdded(distributedPoints)){
            distributePoints(distributedPoints);
            raiseMaxHealthPoints();
            raiseMaxManaPoints();
        }
    }

    private void distributePoints(DistributedPoints distributedPoints) {
        session.getMage().setStrength(distributedPoints.getStrength());
        session.getMage().setCondition(distributedPoints.getCondition());
        session.getMage().setAgility(distributedPoints.getAgility());
        session.getMage().setAccuracy(distributedPoints.getAccuracy());
        session.getMage().setConcentration(distributedPoints.getConcentration());
        session.getMage().setAbilitiesPointsToSpare(0);
    }

    private boolean isCorrectNumberOfPointsAdded(DistributedPoints distributedPoints){
        if(distributedPoints.sumAbilitiesPoints()== session.getMage().getAbilitiesPointsToSpare()) {
            return false;
        }
        else return true;
    }
}
