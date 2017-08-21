package ds.account;

import java.util.Scanner;

/**
 * Created by Damian on 21.08.2017.
 */
public class ConsoleAccountController implements AccountController {

    private Scanner scanner;

    public ConsoleAccountController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String registerAccount(Account account) {
        return null;
    }
}
