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
public class Roar extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public Roar() {
        this.setName("Roar");
        this.setTarget(Target.SELF);
        this.setDescription("Wrrr");
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        target.setHealthPoints(target.getHealthPoints() + 1);
        log.add("healed");
    }
}
