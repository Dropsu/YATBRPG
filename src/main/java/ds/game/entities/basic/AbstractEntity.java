package ds.game.entities.basic;


import ds.game.abillities.basic.Ability;
import ds.game.abillities.other.PhysicalAttack;
import ds.game.equipment.basic.Damage;
import ds.game.equipment.basic.Equipment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@MappedSuperclass
public abstract class AbstractEntity {

	public int level;
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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Equipment equipment;

	public AbstractEntity() {
		this.abilities.add(new PhysicalAttack());
	}

	public AbstractEntity (AbstractEntity other){
		this.name = other.name;
		this.level = other.level;
		this.healthPoints = other.healthPoints;
		this.condition = other.condition;
		this.strength = other.strength;
		this.accuracy = other.accuracy;
		this.agility = other.agility;
		this.noWeaponDamage = other.noWeaponDamage;

		this.abilities = other.abilities;

		this.equipment = null;
	}
}
