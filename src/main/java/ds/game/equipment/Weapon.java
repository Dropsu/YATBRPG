package ds.game.equipment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public abstract class Weapon extends Item {

    @OneToOne(cascade = CascadeType.ALL)
    private Damage damage;

    public Weapon() {
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }
}
