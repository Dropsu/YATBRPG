package ds.game.fight;

import ds.config.Session;
import ds.game.abillities.*;
import ds.game.entities.AbstractEntity;
import ds.game.entities.Mage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Damian on 05.09.2017.
 */

@Service
public class FightService {

    private Session session;
    private RandomOpponentService randomOpponentService;

    @Autowired
    public FightService(Session session, RandomOpponentService randomOpponentService) {
        this.session = session;
        this.randomOpponentService = randomOpponentService;
    }

    public Fight prepareFight(){
        if(session.getFight() ==null) {
            int mageLevel = session.getMage().level;
            AbstractEntity opponent = randomOpponentService.getRandomOpponentForLevel(mageLevel);
            Mage fightMage = new Mage(session.getMage());
            if(fightMage.equipment!=null&&fightMage.equipment.getLeftHandRing()!=null){
                fightMage.equipment.getLeftHandRing().battlePersistentEffect(fightMage);
            }
            if(fightMage.equipment!=null&&fightMage.equipment.getRightHandRing()!=null){
                fightMage.equipment.getRightHandRing().battlePersistentEffect(fightMage);
            }
            session.setFight(new Fight(fightMage, opponent));
        }
        RandomOpponentService randomOpponentService = new RandomOpponentService();
        return session.getFight();
    }

    public Fight nextTurn(Source sourceENUM, String abilityName){ //TODO: Make it prettier
        if(session.getFight().getMage().equipment!=null&&session.getFight().getMage().equipment.getLeftHandRing()!=null){
            session.getFight().getMage().equipment.getLeftHandRing().everyTurnEffect(session.getFight().getMage());
        }
        if(session.getFight().getMage().equipment!=null&&session.getFight().getMage().equipment.getRightHandRing()!=null){
            session.getFight().getMage().equipment.getRightHandRing().everyTurnEffect(session.getFight().getMage());
        }
        handleAbility(sourceENUM,abilityName);

        if(checkIfOpponentAlive()) {
            doOpponentsTurn();
            if(!checkIfPlayerAlive()){
                addToLog((session.getFight().getMage().name + " defeated"));
            }
        } else {
            addToLog(session.getFight().getOpponent().name + " defeated");
        }
        return session.getFight();
    }

    private boolean checkIfOpponentAlive() {
        return session.getFight().getOpponent().healthPoints>0;
    }

    private boolean checkIfPlayerAlive() {
        return session.getFight().getMage().healthPoints>0;
    }

    private void handleAbility(Source sourceENUM, String abilityName){
        Ability ability = determineAbilityFromItsName(sourceENUM,abilityName);
        AbstractEntity source = determineSource(sourceENUM);
        AbstractEntity target = determineTarget(sourceENUM, ability);
        processAbility(source,ability, target);
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
            listToSearchIn = session.getFight().getMage().abilities;
        } else {
            listToSearchIn = session.getFight().getOpponent().abilities;

        }
        return listToSearchIn;
    }

    private AbstractEntity determineTarget(Source source, Ability ability) {
        AbstractEntity target;
        if(source==Source.MAGE){
            if(ability.target== Target.SELF){
                target = session.getFight().getMage();
            } else {
                target= session.getFight().getOpponent();
            }
        } else {
            if(ability.target==Target.SELF){
                target = session.getFight().getOpponent();
            } else {
                target = session.getFight().getMage();
            }
        }
        return target;
    }

    private void addToLog(String message){
        session.getFight().getLog().add(message);
    }

    private AbstractEntity determineSource(Source source) {
        AbstractEntity sourceObject;
        if(source==Source.MAGE){
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
            addToLog(source.name + " missed!!!");
        }
    }

    private boolean checkIfHit(AbstractEntity source, Ability ability, AbstractEntity target) {
        if (!ability.missable) {
            return true;
        }
        double hitChance = 0.7;
        double hitChanceChangePerPointDifference = 0.05;
        int pointsDifference = source.accuracy - target.agility;
        hitChance+=pointsDifference*hitChanceChangePerPointDifference;
        boolean abilityHit = ThreadLocalRandom.current().nextDouble() < hitChance;
        return abilityHit;
    }

    private void doOpponentsTurn(){
        handleAbility(Source.OPPONENT, session.getFight().getOpponent().abilities.get(0).name);
    }

    public void finishFight(){
        boolean playerWon = session.getFight().getMage().healthPoints > 0;
        if(playerWon){
            rewardHero();
        }
        cleanUpAfterFight();
    }

    private void cleanUpAfterFight (){
        session.setFight(null);
    }

    private void rewardHero (){
        session.getMage().experiencePoints+= session.getFight().getOpponent().experienceForDefeating;
    }
}
