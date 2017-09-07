package ds.game.fight;

import ds.config.Session;
import ds.game.abillities.Ability;
import ds.game.abillities.Source;
import ds.game.abillities.Target;
import ds.game.entities.AbstractEntity;
import ds.game.entities.Mage;
import ds.game.entities.Wolf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Damian on 05.09.2017.
 */

@Service
public class FightService {

    Session session;

    @Autowired
    public FightService(Session session) {
        this.session = session;
    }

    public Fight prepareFight(){
        if(session.fight==null) {
            session.fight = new Fight(new Mage(session.mage), new Wolf());
        }
        return session.fight;
    }

    public Fight nextTurn(Source source, String abilityName){

        handleAbility(source,abilityName);

        if(checkIfOpponentAlive()) {
            doOpponentsTurn();
        }
        return session.fight;
    }

    private boolean checkIfOpponentAlive() {
        return session.fight.opponent.healthPoints>0;
    }

    private void handleAbility(Source source, String abilityName){

        Ability ability = determineAbilityFromItsName(source,abilityName);
        AbstractEntity target = determineTarget(source, ability);
        addToLog(source,ability,target);
        causeAbilityEffect(ability, target);
    }


    private Ability determineAbilityFromItsName(Source source,String abilityName) {
        List<Ability> listToSearchIn = determineWhereToLookForAbility(source);
        List<Ability> result = listToSearchIn.stream()
                .filter(ability -> Objects.equals(ability.name, abilityName))
                .collect(Collectors.toList());
        return result.get(0);
    }

    private List<Ability> determineWhereToLookForAbility(Source source) {
        List<Ability> listToSearchIn;
        if(source == Source.MAGE){
            listToSearchIn = session.fight.mage.abilities;
        } else {
            listToSearchIn = session.fight.opponent.abilities;

        }
        return listToSearchIn;
    }

    private AbstractEntity determineTarget(Source source, Ability ability) {
        AbstractEntity target;
        if(source==Source.MAGE){
            if(ability.target== Target.SELF){
                target = session.fight.mage;
            } else {
                target= session.fight.opponent;
            }
        } else {
            if(ability.target==Target.SELF){
                target = session.fight.opponent;
            } else {
                target = session.fight.mage;
            }
        }
        return target;
    }

    private void addToLog(Source source, Ability ability, AbstractEntity target){
        String sourceName = determineSourceName(source);
        session.fight.log.add(sourceName+" has used "+ability.name+" on "+target.name+
        " ("+ability.name+": "+ability.description+")");
    }

    private String determineSourceName(Source source) {
        String sourceName;
        if(source==Source.MAGE){
            sourceName = session.fight.mage.name;
        } else {
            sourceName = session.fight.opponent.name;
        }
        return sourceName;
    }

    private void causeAbilityEffect(Ability ability, AbstractEntity target) {
        ability.causeEffect(target);
    }

    private void doOpponentsTurn(){
        handleAbility(Source.OPPONENT,session.fight.opponent.abilities.get(0).name);
    }
}
