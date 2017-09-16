package ds.game.fight;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Source;
import ds.game.abillities.basic.Target;
import ds.session.Session;
import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.basic.Mage;
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

    private FightPreparator fightPreparator;
    private PlayerTurnHandler playerTurnHandler;
    private OpponentTurnHandler opponentTurnHandler;
    private FightFinisher fightFinisher;

    @Autowired
    public FightService(FightPreparator fightPreparator, PlayerTurnHandler playerTurnHandler,
                        OpponentTurnHandler opponentTurnHandler, FightFinisher fightFinisher) {
        this.fightPreparator = fightPreparator;
        this.playerTurnHandler = playerTurnHandler;
        this.opponentTurnHandler = opponentTurnHandler;
        this.fightFinisher = fightFinisher;
    }

    void prepareFight(){
        fightPreparator.prepareFight();
    }

    void processTurn(Source sourceENUM, String abilityName){
        playerTurnHandler.processPlayersTurn(sourceENUM,abilityName);
        opponentTurnHandler.processOponnentTurn();
    }

    void finishFight(){
        fightFinisher.finishFight();
    }

    }
