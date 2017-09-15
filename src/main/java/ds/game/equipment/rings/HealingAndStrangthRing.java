package ds.game.equipment.rings;

import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Ring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class HealingAndStrangthRing extends Ring {

    @Id
    @GeneratedValue
    private long id;

    public HealingAndStrangthRing() {
        this.name="Healing and strength Ring";
        this.setValue(100);
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.strength+=10;
    }

    @Override
    public void everyTurnEffect(AbstractEntity target) {
        target.healthPoints+=10;
    }
}
