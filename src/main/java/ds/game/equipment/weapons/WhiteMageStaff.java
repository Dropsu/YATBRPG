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
public class WhiteMageStaff extends Weapon {

    @Id
    @GeneratedValue
    private long id;

    public WhiteMageStaff() {
        this.setName("White Mage Staff");
        this.setDamage(new Damage(2,7));
        this.setValue(3);
        this.setDescription("Does its job");
    }

}
