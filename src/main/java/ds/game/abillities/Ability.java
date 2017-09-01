package ds.game.abillities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ability {
    @Id
    @GeneratedValue
    private long id;

    public Ability() {
    }
}
