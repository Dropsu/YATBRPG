package ds.game.entities.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 27.11.2017.
 */
@Entity
public class MagicallyDisabled extends MagicalAbilities {

    @Id
    @GeneratedValue
    private int id;

    @Override
    public MagicalAbilities shallowCopy() {
        return new MagicallyDisabled();
    }



    @Override
    public int getConcentration() {
        return 0;
    }

    @Override
    public int getManaPoints() {
        return 0;
    }

    @Override
    public void setConcentration(int concentration) {

    }

    @Override
    public void setManaPoints(int manaPoints) {

    }

    @Override
    public void decreaseConcentration(int points) {

    }

    @Override
    public void decreaseManaPoints(int points) {

    }
}
