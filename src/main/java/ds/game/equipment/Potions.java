package ds.game.equipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 12.09.2017.
 */
@Entity
public class Potions {

    @Id
    @GeneratedValue
    private long id;

    private int healthPotions;
    private int manaPotions;

    public Potions() {
    }

    public int getHealthPotions() {
        return healthPotions;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotions = healthPotions;
    }

    public int getManaPotions() {
        return manaPotions;
    }

    public void setManaPotions(int manaPotions) {
        this.manaPotions = manaPotions;
    }
}
