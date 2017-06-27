package ds.test;

import ds.account.Account;
import ds.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Damian on 24.06.2017.
 */

@RestController
public class testController {

    @Autowired
    AccountRepository repository;

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
    public List<Account> testRepo (){
        List<Account> accounts = repository.findByusername("Damian");
        return accounts;
    }

}
