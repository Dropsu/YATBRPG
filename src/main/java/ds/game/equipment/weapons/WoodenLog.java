package ds.game.equipment.weapons;

import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;
import ds.game.equipment.basic.Weapon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class WoodenLog extends Weapon {

    @Id
    @GeneratedValue
    private long id;

    public WoodenLog() {
        this.setName("Wooden Log");
        this.setDamage(new Damage(6,12));
        this.setValue(5);
        this.setDescription("Quite Heavy, not a lot strength left for your opponent, -2 strength");
    }

    @Override
    public void battlePersistentEffect(AbstractEntity target) {
        target.setStrength(target.getStrength()-2);
    }
}
