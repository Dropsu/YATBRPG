package ds.game.entities.basic;

import javax.persistence.*;

/**
 * Created by Damian on 24.08.2017.
 */
@Entity
public class Mage extends AbstractMagicalEntity implements PlayersHero {

    @Id
    @GeneratedValue
    private Long id;

    private int experiencePoints;
    private int abilitiesPointsToSpare;

    private int concentration;

    public Mage() {
    }

    public Mage (Mage other){
        super(other);
        this.setManaPoints(other.getManaPoints());
        this.setConcentration(other.getConcentration());
        this.setEquipment(other.getEquipment());
        this.getEquipment().potions = other.getEquipment().potions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getAbilitiesPointsToSpare() {
        return abilitiesPointsToSpare;
    }

    public void setAbilitiesPointsToSpare(int abilitiesPointsToSpare) {
        this.abilitiesPointsToSpare = abilitiesPointsToSpare;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        if(concentration<0){
            this.concentration=0;
        } else {
            this.concentration = concentration;
        }
    }
}
