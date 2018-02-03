package org.viarzilin.hospital.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  @Qualifier("userDetailsService")
  UserDetailsService userDetailsService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
    authentication.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login").access("permitAll()")
        .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/doctor/*").access("hasRole('ROLE_DOCTOR')")
        .antMatchers("/nurse/*").access("hasRole('ROLE_NURSE')")
        .antMatchers("/general/*").access("hasRole('ROLE_NURSE')||hasRole('ROLE_DOCTOR')")
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/access_denied.html")
        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
        .and().csrf().disable();
  }
}