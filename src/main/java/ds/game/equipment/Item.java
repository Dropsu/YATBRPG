package ds.game.equipment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 31.08.2017.
 */
@Entity
public abstract class Item {

    @Id
    @GeneratedValue
    protected long id;

    protected String name;
    protected int value;

    public Item() {
    }
}
