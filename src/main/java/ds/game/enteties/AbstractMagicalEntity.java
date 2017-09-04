package ds.game.enteties;

import java.util.List;

public abstract class AbstractMagicalEntity extends AbstractEntity {
	private int actualMana;
	private int maxMana;
	private int manaRegen;
	List<Spell> spells;
}
