package ds.game.equipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Damian on 08.09.2017.
 */
@Entity
public class Damage {

    @Id
    @GeneratedValue
    private long id;

    public int minDamage;
    public int maxDamage;

    public Damage() {
    }

    public Damage(int minDamage, int maxDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getRandomDamage(){
        return ThreadLocalRandom.current().nextInt(minDamage, maxDamage + 1);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}
