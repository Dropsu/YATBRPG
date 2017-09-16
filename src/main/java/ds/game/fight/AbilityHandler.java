package ds.game.fight;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Source;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Damian on 16.09.2017.
 */
@Service
public class AbilityHandler {

    private Session session;
    private FightLogger fightLogger;

    @Autowired
    public AbilityHandler(Session session, FightLogger fightLogger) {
        this.session = session;
        this.fightLogger = fightLogger;
    }

    public void handleAbility(Source sourceENUM, String abilityName){
        Ability ability = determineAbilityFromItsName(sourceENUM,abilityName);
        AbstractEntity source = translateSourceENUMtoObjectFromFight(sourceENUM);
        AbstractEntity target = determineTarget(sourceENUM, ability);
        processAbility(source,ability, target);
    }


    private Ability determineAbilityFromItsName(Source source,String abilityName) {
        List<Ability> listToSearchIn = determineWhereToLookForAbility(source);
        List<Ability> result = listToSearchIn.stream()
                .filter(ability -> Objects.equals(ability.getName(), abilityName))
                .collect(Collectors.toList());
        return result.get(0);
    }

    private List<Ability> determineWhereToLookForAbility(Source source) {
        List<Ability> listToSearchIn;
        if(source == Source.MAGE){
            listToSearchIn = session.getFight().getMage().getAbilities();
        } else {
            listToSearchIn = session.getFight().getOpponent().getAbilities();

        }
        return listToSearchIn;
    }

    private AbstractEntity determineTarget(Source source, Ability ability) {
        AbstractEntity target;
        if(source==Source.MAGE){
            if(ability.getTarget() == Target.SELF){
                target = session.getFight().getMage();
            } else {
                target= session.getFight().getOpponent();
            }
        } else {
            if(ability.getTarget() ==Target.SELF){
                target = session.getFight().getOpponent();
            } else {
                target = session.getFight().getMage();
            }
        }
        return target;
    }

    private AbstractEntity translateSourceENUMtoObjectFromFight(Source sourceENUM) {
        AbstractEntity sourceObject;
        if(sourceENUM==Source.MAGE){
            sourceObject = session.getFight().getMage();
        } else {
            sourceObject = session.getFight().getOpponent();
        }
        return sourceObject;
    }

    private void processAbility(AbstractEntity source, Ability ability, AbstractEntity target) {
        if(checkIfHit(source,ability,target)){
            ability.use(source, target, session.getFight().getLog());
        } else {
            fightLogger.addToLog(source.getName() + " missed!!!");
        }
    }

    private boolean checkIfHit(AbstractEntity source, Ability ability, AbstractEntity target) {
        if (!ability.isMissable()) {
            return true;
        }
        double hitChance = 0.7;
        double hitChanceChangePerPointDifference = 0.05;
        int pointsDifference = source.getAccuracy() - target.getAgility();
        hitChance+=pointsDifference*hitChanceChangePerPointDifference;
        boolean abilityHit = ThreadLocalRandom.current().nextDouble() < hitChance;
        return abilityHit;
    }

}
