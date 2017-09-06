package ds.game.fight;

import ds.config.Session;
import ds.game.abillities.Ability;
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

    public Fight handleAction(String abilityName){ //TODO: make it prettier
        List<Ability> result = session.mage.abilities.stream()
                .filter(ability -> Objects.equals(ability.name, abilityName))
                .collect(Collectors.toList());
        Ability ability = result.get(0);

        AbstractEntity target = null;
        if(ability.target==Target.SELF){
            target=session.fight.mage;
        } else if (ability.target==Target.OTHER) {
            target = session.fight.opponent;
        }
        ability.Effect(target);
        return session.fight;
    }

    public void addToLog(String abilityName){
        session.fight.log.add(abilityName);
    }
}
