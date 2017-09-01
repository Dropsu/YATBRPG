package ds.game.abillities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Spell extends Ability {

    @Id
    @GeneratedValue
    private long id;

    public Spell() {
    }

}
