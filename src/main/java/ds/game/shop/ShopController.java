package ds.game.shop;

import ds.game.equipment.Equipment;

/**
 * Created by Damian on 13.09.2017.
 */

public interface ShopController {
    String equipmentPage();
    void buyItem();
    Equipment sellItem(String itemType);
}
