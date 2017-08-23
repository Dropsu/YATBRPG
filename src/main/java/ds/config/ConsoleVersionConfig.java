package ds.config;

import ds.account.ConsoleAccountController;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
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

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;

    }

}
