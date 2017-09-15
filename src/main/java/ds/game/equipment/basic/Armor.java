package ds.game.equipment.basic;

import javax.persistence.Entity;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public abstract class Armor extends Item {

    private int damageReduction;

    public Armor() {
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }
}
