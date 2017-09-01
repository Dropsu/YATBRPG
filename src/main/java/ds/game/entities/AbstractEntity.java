package ds.game.entities;


import ds.game.abillities.Ability;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;
@MappedSuperclass
public abstract class AbstractEntity {
	
	protected String name;
	protected int healthPoints;
	protected int healthRegen;
	
	protected int strength;
	protected int accuracy;
	protected int agility;
	protected int condition;

	protected int noWeaponDamage;

	@OneToMany
	protected List<Ability> abilities;

}
