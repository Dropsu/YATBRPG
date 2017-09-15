package ds.game.entities.basic;

import ds.game.entities.basic.AbstractEntity;

import javax.persistence.MappedSuperclass;

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
