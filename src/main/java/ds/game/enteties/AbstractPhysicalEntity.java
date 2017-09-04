package ds.game.enteties;

import java.util.List;

public abstract class AbstractPhysicalEntity extends AbstractEntity {
	
	private int actualEnergy;
	private int maxEnergy;
	private int energyRegen;
	List<Ability>abylities;
}
