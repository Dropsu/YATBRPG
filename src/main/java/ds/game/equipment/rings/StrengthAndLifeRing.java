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
public class StrengthAndLifeRing extends Ring {

    @Id
    @GeneratedValue
    private long id;

    public StrengthAndLifeRing() {
        this.setName("Strength and Life Ring");
        this.setValue(100);
        this.setDescription("Add 2 strength during fight and heals for 3 Health Points every turn");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.setStrength(target.getStrength() + 2);
    }

    @Override
    public void everyTurnEffect(AbstractEntity target) {
        target.setHealthPoints(target.getHealthPoints() + 3);
    }
}
