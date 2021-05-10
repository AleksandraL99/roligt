package pl.roligt.roligt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService ()
    {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    /*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/register", "/main", "/rosnotlog","/priceList").permitAll()
		.antMatchers("/resadmin").hasRole("ADMIN")
		.antMatchers("/reservations").hasRole("USER")
		.anyRequest().authenticated()
		.formLogin()
			.loginPage("/loginpage")
			.defaultSuccessUrl("/")
			.and()
		.logout()
			.logoutSuccessUrl("/")
    }*/
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/loginpage", "/register", "/main", "/rosnotlog","/priceList","/resadmin").permitAll()
                //.antMatchers("/resadmin").authenticated()
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/main");
    }
}

