package ds.game.equipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public class Armor extends Item {

    public double damageReduction;

    public Armor() {
    }
}
