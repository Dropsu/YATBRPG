package ds.security;

import ds.account.AccountRepository;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.
configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Profile("dev")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    AccountRepository accountRepository;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin().loginPage("/login")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/account/register").permitAll();

                httpSecurity.authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .and().headers().frameOptions().disable().and()
                .csrf().disable();
    }

 @Override protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource())
                .usersByUsernameQuery(
                        "select username, password, true " +
                                "from account where username=?")
                .authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from account where username=?");
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }



}
