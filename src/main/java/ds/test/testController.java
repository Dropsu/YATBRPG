package ds.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian on 24.06.2017.
 */

@RestController
public class testController {
    private class Test {
        public int lvl;
        public String name;
        public String ability;
        protected Test (int lvl, String name,String ability) {
            this.lvl = lvl;
            this.name = name;
            this.ability = ability;
        }
    }

    @RequestMapping("/test")
    public Test retreiveTestObject (){
        Test t1 = new Test(999999,"Dimitra","Super Awesomeness and being the best girl in the world!!!");
        return t1;
    }

}
