package ds.game.abillities.other;

import ds.game.abillities.basic.Ability;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class ExhaustingAttack extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public ExhaustingAttack() {
        this.setName("Exhausting Attack");
        this.setTarget(Target.OTHER);
        this.setDescription("Perform exhausting attack with added strength, but then loose strength");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int strengthAdded = 4;
        int strengthDecrease = 1;
        log.add(source.getName()+" performs exhaustive physical attack with +"+strengthAdded+"" +
                " strength but then losses "+strengthDecrease+" strenght for the rest of the fight");
        source.setStrength(source.getStrength()+strengthAdded);
        source.getAbilities().get(0).use(source,target,log);
        source.setStrength(source.getStrength()-(strengthAdded+strengthDecrease));
    }
}
