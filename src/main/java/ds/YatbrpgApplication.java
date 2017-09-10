package ds;

import ds.account.Account;
import ds.account.AccountRepository;
import ds.config.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebListener;

@SpringBootApplication
@EnableJpaRepositories
public class YatbrpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(YatbrpgApplication.class, args);
	}
}
