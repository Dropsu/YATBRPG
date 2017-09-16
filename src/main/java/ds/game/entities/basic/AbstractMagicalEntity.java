package ds.game.entities.basic;

import ds.game.entities.basic.AbstractEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractMagicalEntity extends AbstractEntity {

	private int manaPoints;
	private int manaRegeneration;

	public AbstractMagicalEntity() {
	}

	public AbstractMagicalEntity(AbstractEntity other) {
		super(other);
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}

	public int getManaRegeneration() {
		return manaRegeneration;
	}

	public void setManaRegeneration(int manaRegeneration) {
		this.manaRegeneration = manaRegeneration;
	}
}
