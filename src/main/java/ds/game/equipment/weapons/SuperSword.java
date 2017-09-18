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
public class SuperSword extends Weapon {

    @Id
    @GeneratedValue
    private long id;

    public SuperSword() {
        this.setName("Super Sword");
        this.setDamage(new Damage(7,11));
        this.setValue(70);
        this.setDescription("And that is a weapon, no hidden tricks, just damage");
    }
}
