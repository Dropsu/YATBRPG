package ds.game.abillities;

import ds.game.entities.AbstractEntity;

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
        this.name="Roar";
        this.target=Target.SELF;
        this.description = "Wrrr";
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        target.healthPoints+=1;
        log.add("healed");
    }
}
