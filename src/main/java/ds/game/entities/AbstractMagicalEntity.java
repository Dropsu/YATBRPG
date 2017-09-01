package ds.game.entities;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class AbstractMagicalEntity extends AbstractEntity {
	protected int manaPoints;
	protected int manaRegeneration;
}
