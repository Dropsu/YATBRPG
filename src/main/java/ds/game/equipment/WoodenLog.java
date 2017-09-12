package ds.game.equipment;

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
        this.name="Wooden Log";
        this.setDamage(new Damage(10,20));
        this.setValue(1);
    }
}
