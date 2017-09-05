package ds.game.entities;


import ds.game.abillities.Ability;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Ability> abilities = new ArrayList<>();

}
