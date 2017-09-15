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
public class MatchThrow extends Spell {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Damage damage;


    public MatchThrow() {
        this.name="Match Throw";
        this.target= Target.OTHER;
        this.damage = new Damage(1,4);
        this.description = "Throws a match in opponents's face - deal "+damage+" damage.";
        this.missable = true;
        this.cost = 15;
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        log.add(source.name + " throws a match in " + target.name+" dealing "+damage+" damage");
        target.healthPoints -= (damage.getRandomDamage() + getSpellLevel()*2);
    }
}
