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

	private int level;
	private String name;
	private int healthPoints;
	private int healthRegen;
	
	private int strength;
	private int accuracy;
	private int agility;
	private int condition;
	private int experienceForDefeating;
	private int goldForDefeating;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MagicalAbilities magicalAbilities;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Damage noWeaponDamage;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ability> abilities = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Equipment equipment;

	public AbstractEntity() {
		this.getAbilities().add(new PhysicalAttack());
	}

	public AbstractEntity (AbstractEntity other){
		this.setName(other.getName());
		this.setLevel(other.getLevel());
		this.setHealthPoints(other.getHealthPoints());
		this.setCondition(other.getCondition());
		this.setStrength(other.getStrength());
		this.setAccuracy(other.getAccuracy());
		this.setAgility(other.getAgility());
		this.setNoWeaponDamage(other.getNoWeaponDamage());

		this.setAbilities(other.getAbilities());

		this.setEquipment(null);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getHealthRegen() {
		return healthRegen;
	}

	public void setHealthRegen(int healthRegen) {
		this.healthRegen = healthRegen;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		if (strength<0){
			this.strength=0;
		} else {
			this.strength = strength;
		}
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		if(accuracy<0){
			this.accuracy=0;
		} else {
			this.accuracy = accuracy;
		}
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		if(agility<0){
			this.agility=0;
		} else {
			this.agility = agility;
		}
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		if(condition<0){
			this.condition=0;
		} else {
			this.condition = condition;
		}
	}

	public int getExperienceForDefeating() {
		return experienceForDefeating;
	}

	public void setExperienceForDefeating(int experienceForDefeating) {
		this.experienceForDefeating = experienceForDefeating;
	}

	public Damage getNoWeaponDamage() {
		return noWeaponDamage;
	}

	public void setNoWeaponDamage(Damage noWeaponDamage) {
		this.noWeaponDamage = noWeaponDamage;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public int getGoldForDefeating() {
		return goldForDefeating;
	}

	public void setGoldForDefeating(int goldForDefeating) {
		this.goldForDefeating = goldForDefeating;
	}

	public MagicalAbilities getMagicalAbilities() {
		return magicalAbilities;
	}

	public void setMagicalAbilities(MagicalAbilities magicalAbilities) {
		this.magicalAbilities = magicalAbilities;
	}
}
