package ds.game.entities;

import ds.game.abillities.Spell;
import ds.game.equipment.Equipment;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damian on 24.08.2017.
 */
@Entity
public class Mage extends AbstractMagicalEntity implements PlayersHero {

    @Id
    @GeneratedValue
    private Long id;

    public int level;
    public int experiencePoints;

    public int gold;

    @OneToOne
    public Equipment equipment;

    public int concentration;

    @OneToMany
    public List<Spell> spells;

    public int sumAbilitiesPoints () {
        //TODO: Marcelu, zwroc sume atrybutow
        return 0;
    }

    public Mage () {
        this.level = 0;
        this.experiencePoints = 0;

        this.gold = 0;
        this.equipment = null;

        this.concentration=10;
        this.strength = 10;
        this.accuracy=10;
        this.agility = 10;
        this.condition=10;

        this.healthPoints=10;
        this.healthRegen=0;
        this.manaPoints=20;
        this.manaRegeneration=0;
        this.noWeaponDamage=1;

        this.abilities = null;
        this.spells = null;
    }
}
