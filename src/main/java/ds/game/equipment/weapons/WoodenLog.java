package ds.game.equipment.weapons;

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
        this.setDamage(new Damage(10,20));
        this.setValue(1);
        this.setDescription("Quite Heavy");
    }
}
