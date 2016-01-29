package com.catalyst.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

/**
 * Created by rhanberry on 1/25/2016.
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    private CustomLogOutSuccessHandler logoutSuccessHandler;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(encoder())
                .usersByUsernameQuery("SELECT email, password FROM enduser WHERE email=?")
                .authoritiesByUsernameQuery("SELECT enduser.email,springrole.role FROM springrole JOIN enduser ON springrole.roleid=enduser.springroleid WHERE enduser.email=?");//this fakes a user role
          
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/**").authenticated().and().formLogin().loginPage("/login").permitAll();
    	
        http.formLogin().loginProcessingUrl("/login");
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler)
        .and().headers().cacheControl()
        .and()
        .logout()
        .logoutSuccessHandler(logoutSuccessHandler)
        .logoutSuccessUrl("/login")
        .deleteCookies("JSESSIONID", "CSRF-TOKEN")
        .permitAll();

    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource datasource;

    public void setDatasource(DataSource datasource){
        this.datasource = datasource;
    }


}
