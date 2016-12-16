package in.colorlfire.config;

import in.colorlfire.serivce.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author colorfire on 16/12/10
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(new CustomUserDetailsService());
  }

  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/", "/index").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").defaultSuccessUrl("/user").permitAll()
            .and().logout().permitAll();
  }

}
