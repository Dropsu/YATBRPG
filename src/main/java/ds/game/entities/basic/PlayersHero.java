package ds.game.entities.basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damian on 27.11.2017.
 */
@Entity
public abstract class PlayersHero extends AbstractEntity {

    @Id
    @GeneratedValue
    private long id;

    private int experiencePoints;
    private int abilitiesPointsToSpare;

    public PlayersHero() {
    }

    public PlayersHero (PlayersHero other){
        super(other);
        this.setId(other.getId());
        this.setMagicalAbilities(other.getMagicalAbilities().shallowCopy());
        this.getMagicalAbilities().setManaPoints(other.getMagicalAbilities().getManaPoints());
        this.getMagicalAbilities().setConcentration(other.getMagicalAbilities().getConcentration());
        this.setEquipment(other.getEquipment());
        this.getEquipment().potions = other.getEquipment().potions;
        this.experiencePoints = other.getExperiencePoints();
        this.abilitiesPointsToSpare = other.getAbilitiesPointsToSpare();
    }

    public abstract PlayersHero copy ();

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
