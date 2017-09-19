package ds.game.abillities.spells;

import ds.game.abillities.basic.Spell;
import ds.game.abillities.basic.Target;
import ds.game.entities.basic.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Damian on 05.09.2017.
 */
@Entity
public class LightHealSpell extends Spell {

    @Id
    @GeneratedValue
    private long id;
    private int healthPointsGain = 15;


    public LightHealSpell() {
        this.setName("Light Healing Spell");
        this.setTarget(Target.SELF);
        this.setDescription("Heals you for "+ healthPointsGain);
        this.setMissable(false);
        this.setCost(25);
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        log.add(source.getName()+"uses "+this.getName()+" and gains "+this.healthPointsGain+" health Points");
        target.setHealthPoints(target.getHealthPoints()+healthPointsGain);
    }
}
