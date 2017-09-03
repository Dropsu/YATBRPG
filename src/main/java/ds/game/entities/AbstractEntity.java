package ds.game.entities;


import ds.game.abillities.Ability;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;
@MappedSuperclass
public abstract class AbstractEntity {
	
	public String name;
	public int healthPoints;
	public int healthRegen;
	
	public int strength;
	public int accuracy;
	public int agility;
	public int condition;

	public int noWeaponDamage;

	@OneToMany
	public List<Ability> abilities;

}
