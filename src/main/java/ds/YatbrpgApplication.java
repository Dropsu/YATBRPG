package ds;

import ds.account.Account;
import ds.account.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class YatbrpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(YatbrpgApplication.class, args);
	}

}
