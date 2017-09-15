package ds.game.fight;

import ds.game.entities.basic.AbstractEntity;
import ds.game.entities.opponents.SmallStoneGolem;
import ds.game.entities.opponents.Wolf;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Damian on 12.09.2017.
 */

@Component
public class RandomOpponentService {
    private List<AbstractEntity> opponents = new LinkedList<>();

    public RandomOpponentService() {
        opponents.add(new Wolf());
        opponents.add(new SmallStoneGolem());
    }

    public AbstractEntity getRandomOpponentForLevel(int level) { //TODO: would be sufficient to store class
        List<AbstractEntity> resultForLevel;
        resultForLevel = opponents.stream().filter(opponent -> opponent.level==level)
                .collect(Collectors.toList());
        int randomIndex = ThreadLocalRandom.current().nextInt(0,resultForLevel.size());
        Class classOfOpponent = resultForLevel.get(randomIndex).getClass();
        AbstractEntity abstractEntity = null;
        try {
            abstractEntity = (AbstractEntity)classOfOpponent.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return abstractEntity ;
    }
}
