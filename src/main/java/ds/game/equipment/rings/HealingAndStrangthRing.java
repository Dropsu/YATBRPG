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
        this.setName("Healing and strength Ring");
        this.setValue(100);
        this.setDescription("Health and strength");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.setStrength(target.getStrength() + 10);
    }

    @Override
    public void everyTurnEffect(AbstractEntity target) {
        target.setHealthPoints(target.getHealthPoints() + 10);
    }
}
