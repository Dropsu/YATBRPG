package ds.game.shop;

import ds.game.equipment.basic.Equipment;

/**
 * Created by Damian on 13.09.2017.
 */

public interface ShopController {
    String equipmentPage();
    Equipment buyItem(String itemName, String itemType);
    Equipment sellItem(String itemType);
    ShopItems serveItemFromShop();
    Equipment buyPotions(int number,String type);


}
