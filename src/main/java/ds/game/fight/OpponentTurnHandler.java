package ds.game.fight;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Source;
import ds.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Damian on 16.09.2017.
 */
@Service
public class OpponentTurnHandler {

    private Session session;
    private AbilityHandler abilityHandler;
    private FightLogger fightLogger;

    @Autowired
    public OpponentTurnHandler(Session session, AbilityHandler abilityHandler,
                               FightLogger fightLogger) {
        this.session = session;
        this.abilityHandler = abilityHandler;
        this.fightLogger = fightLogger;
    }

    public void processOponnentTurn() {
        if(checkIfOpponentAlive()) {
            doOpponentsTurn();
            if(!checkIfPlayerAlive()){
                fightLogger.addToLog((session.getFight().getMage().getName() + " defeated"));
            }
        } else {
            fightLogger.addToLog(session.getFight().getOpponent().getName() + " defeated");
            fightLogger.addToLog("You get "+session.getFight().getOpponent().getExperienceForDefeating()+ " experience and "
                    +session.getFight().getOpponent().getGoldForDefeating()+" gold.");
        }
    }

    private boolean checkIfOpponentAlive() {
        return session.getFight().getOpponent().getHealthPoints() >0;
    }

    private boolean checkIfPlayerAlive() {
        return session.getFight().getMage().getHealthPoints() >0;
    }

    private void doOpponentsTurn(){
        List<Ability> abilities = session.getFight().getOpponent().getAbilities();
        int abilityNumber = ThreadLocalRandom.current().nextInt(0,abilities.size());
        abilityHandler.handleAbility(Source.OPPONENT, abilities.get(abilityNumber).getName());
    }
}

