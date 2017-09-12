package ds.game.entities;

import ds.game.abillities.MatchThrow;
import ds.game.abillities.Spell;
import ds.game.equipment.Damage;
import ds.game.equipment.Equipment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 24.08.2017.
 */
@Entity
public class Mage extends AbstractMagicalEntity implements PlayersHero {

    @Id
    @GeneratedValue
    private Long id;

    public int experiencePoints;
    public int abilitiesPointsToSpare;

    public int gold;

    @OneToOne
    public Equipment equipment;

    public int concentration;

    public Mage() {
    }

    public Mage (String login) {
        this.name = login + "'s hero";
        this.level = 1;
        this.experiencePoints = 0;
        this.abilitiesPointsToSpare = 4;

        this.gold = 0;
        this.equipment = null;

        this.concentration=10;
        this.strength = 10;
        this.accuracy=10;
        this.agility = 10;
        this.condition=10;

        this.healthPoints=10;
        this.healthRegen=0;
        this.manaPoints=40;
        this.manaRegeneration=0;
        this.noWeaponDamage=new Damage(1,3);

        this.abilities.add(new MatchThrow());
    }

    public Mage (Mage other){
        super(other);
        this.manaPoints = other.manaPoints;
        this.concentration = other.concentration;
    }
}
