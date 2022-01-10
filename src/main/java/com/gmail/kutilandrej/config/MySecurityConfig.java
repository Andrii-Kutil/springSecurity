package com.gmail.kutilandrej.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//    auth.inMemoryAuthentication()
//        .withUser(userBuilder.username("employee").password("employee").roles("employee"))
//        .withUser(userBuilder.username("hr").password("hr").roles("hr"))
//        .withUser(
//            userBuilder.username("manager").password("manager").roles("manager", "employee", "hr"));
    auth.jdbcAuthentication().dataSource(dataSource);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/humans").hasAnyRole("MANAGER", "EMPLOYEE", "HR")
        .antMatchers("/hrs/info").hasAnyRole("MANAGER", "HR")
        .antMatchers("/managers/info").hasAnyRole("MANAGER")
        .and().formLogin().permitAll();
  }
}
