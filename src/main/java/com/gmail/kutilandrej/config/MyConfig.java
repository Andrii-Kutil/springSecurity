package com.gmail.kutilandrej.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.gmail.kutilandrej")
public class MyConfig {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource datasource = new ComboPooledDataSource();
    try {
      datasource.setDriverClass("com.mysql.cj.jdbc.Driver");
      datasource.setJdbcUrl("jdbc:mysql://localhost:3306/db?useSSL=false");
      datasource.setUser("user");
      datasource.setPassword("M4Q5ZVBDRB2fRmNbVg6P");
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    return datasource;
  }
}
