package ds.game.equipment;

import javax.persistence.Entity;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public class Weapon extends Item {
    private int minDamage;
    private int maxDamage;
    private double criticalStrikeChance;

    public Weapon() {
    }
}
