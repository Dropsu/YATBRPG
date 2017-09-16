package ds.account;

import ds.game.entities.basic.Mage;

/**
 * Created by Damian on 15.09.2017.
 */
public interface MageCreator {
    Mage buildMageForNewAccount(String username);
}
