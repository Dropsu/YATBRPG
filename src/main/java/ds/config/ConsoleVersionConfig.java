package ds.config;

import ds.account.ConsoleAccountController;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * Created by Damian on 21.08.2017.
 */

@Configuration
public class ConsoleVersionConfig {
    public ConsoleAccountController consoleAccountController () {
        return new ConsoleAccountController(new Scanner(System.in));
    }
}
