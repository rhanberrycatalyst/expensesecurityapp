package com.catalyst.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by rhanberry on 1/25/2016.
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;

    public void setDatasource(DataSource datasource){
        this.datasource = datasource;
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(encoder())
                .usersByUsernameQuery("SELECT email, password, isactive FROM enduser WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, 'USER' FROM enduser WHERE email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {      
        super.configure(http);
        http.csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }



}
