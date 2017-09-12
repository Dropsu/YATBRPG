package ds.game.entities;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class AbstractMagicalEntity extends AbstractEntity {
	public static int LEVEL;

	public int manaPoints;
	public int manaRegeneration;

	public AbstractMagicalEntity() {
	}

	public AbstractMagicalEntity(AbstractEntity other) {
		super(other);
	}
}
