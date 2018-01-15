package ds.game.entities.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 27.11.2017.
 */
@Entity
public class MagicallyAble extends MagicalAbilities {

    private int concentration;
    private int manaPoints;

    @Override
    public MagicalAbilities shallowCopy() {
        return new MagicallyAble(this.concentration,this.manaPoints);
    }

    public MagicallyAble() {
    }

    public MagicallyAble(int concentration, int manaPoints) {
        this.concentration = concentration;
        this.manaPoints = manaPoints;
    }

    @Override
    public int getConcentration() {
        return concentration;
    }

    @Override
    public int getManaPoints() {
        return manaPoints;
    }

    @Override
    public void setConcentration(int concentration) {
        if(concentration<0){
            this.concentration=0;
        } else {
            this.concentration = concentration;
        }
    }

    @Override
    public void setManaPoints(int manaPoints) {
        this.manaPoints=manaPoints;
    }

    @Override
    public void decreaseConcentration(int points) {
        this.concentration-=points;
    }

    @Override
    public void decreaseManaPoints(int points) {
        this.manaPoints-=points;
    }
}
