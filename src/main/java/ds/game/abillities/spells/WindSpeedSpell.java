package ds.game.abillities.spells;

import ds.game.abillities.basic.Spell;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;
import ds.game.equipment.basic.Damage;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class WindSpeedSpell extends Spell {

    @Id
    @GeneratedValue
    private long id;
    private int accuracyGain = 1;
    private int agilityGain = 1;


    public WindSpeedSpell() {
        this.setName("Wind Speed Spell");
        this.setTarget(Target.SELF);
        this.setDescription("Gives you speed of the wind, adds "+accuracyGain+" Accuracy and "+
        accuracyGain+" agility");
        this.setMissable(false);
        this.setCost(15);
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        log.add(source.getName()+"uses "+this.getName()+" and gains "+accuracyGain+" accuracy" +
                " and "+agilityGain+" agility.");
        target.setAgility(target.getAgility()+agilityGain);
        target.setAccuracy(target.getAccuracy()+accuracyGain);
    }
}
