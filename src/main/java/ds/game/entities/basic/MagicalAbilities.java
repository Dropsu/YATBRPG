package ds.game.entities.basic;

import javax.persistence.*;

/**
 * Created by Damian on 27.11.2017.
 */


@Entity
public abstract class MagicalAbilities {

    @Id
    @GeneratedValue
    private int id;

    abstract public MagicalAbilities shallowCopy();

    abstract public int getConcentration();
    abstract public int getManaPoints();

    abstract public void setConcentration(int concentration);
    abstract public void setManaPoints( int manaPoints);

    abstract public void decreaseConcentration(int points);
    abstract public void decreaseManaPoints(int points);
}
