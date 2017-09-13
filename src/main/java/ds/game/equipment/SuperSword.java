package ds.game.equipment;

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
        this.name="Super Sword";
        this.setDamage(new Damage(500,1000));
        this.setValue(15);
    }
}
