package ds.game.abillities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Spell extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public int manaCost;

    public Spell() {
    }
}
