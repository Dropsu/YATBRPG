package ds.game.entities;


import ds.game.abillities.Ability;
import ds.game.abillities.PhysicalAttack;
import ds.game.equipment.Damage;

import javax.persistence.*;
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
	public int experienceForDefeating;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Damage noWeaponDamage;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Ability> abilities = new ArrayList<>();

	public AbstractEntity() {
		this.abilities.add(new PhysicalAttack());
	}
}
