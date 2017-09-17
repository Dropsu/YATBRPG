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
        this.setName("Match Throw");
        this.setTarget(Target.OTHER);
        this.damage = new Damage(1,4);
        this.setDescription("Throws a match in opponents's face - deal "+damage+" damage.");
        this.setMissable(true);
        this.setCost(15);
    }

    @Override
    protected void causeEffect(AbstractEntity source, AbstractEntity target, List<String> log) {
        int damageDealt = damage.getRandomDamage();
        log.add(source.getName() + " throws a match in " + target.getName() +" dealing "+damageDealt+" damage");
        target.setHealthPoints(target.getHealthPoints() - (damageDealt));
    }
}
