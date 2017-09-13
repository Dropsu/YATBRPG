package ds.game.shop;

import ds.game.equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damian on 13.09.2017.
 */
@Controller
@RequestMapping("/equipment")
public class ShopControllerImpl implements ShopController {

    private ShopService shopService;

    @Autowired
    public ShopControllerImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public String equipmentPage() {
        return "equipment";
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Equipment serveItems() {
        return shopService.serveItems();
    }

    @Override
    public void buyItem() {

    }

    @Override
    @RequestMapping("/sell")
    public @ResponseBody
    Equipment sellItem(String itemType) {
        return shopService.sellItem(itemType);
    }
}
