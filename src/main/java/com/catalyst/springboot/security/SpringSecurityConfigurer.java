package com.catalyst.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import javax.sql.DataSource;


@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	CustomAuthenticationEntryPoint authenticationEntryHandler() {
		return new CustomAuthenticationEntryPoint();
	}

	/**
	 * @param authEntry
	 *            the authEntry to set
	 */
	public void setEntry(CustomAuthenticationFailureHandler authEntry) {
		this.authenticationFailureHandler = authEntry;
	}
	

	@Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	CustomAuthenticationFailureHandler authenticationHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	/**
	 * @param authFailure
	 *            the authFailure to set
	 */
	public void setAuthFailure(CustomAuthenticationFailureHandler authFailure) {
		this.authenticationFailureHandler = authFailure;
	}
	
    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Bean
	CustomAuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	/**
	 * @param authSuccess
	 *            the authSuccess to set
	 */
	public void setAuthSuccess(CustomAuthenticationSuccessHandler authSuccess) {
		this.authenticationSuccessHandler = authSuccess;
	}
	
    
    
    @Autowired
    private CustomLogOutSuccessHandler logoutSuccessHandler;
    @Bean
    CustomLogOutSuccessHandler logoutSuccessHandler() {
   		return new CustomLogOutSuccessHandler();
   	}

   	/**
   	 * @param logoutSuccess
   	 *            the logoutSuccess to set
   	 */
   	public void setLogOutSuccess(CustomLogOutSuccessHandler logoutSuccess) {
   		this.logoutSuccessHandler = logoutSuccess;
   	}
    
    


    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(encoder())
                .usersByUsernameQuery("SELECT enduser.email,enduser.password FROM enduser WHERE email=?")
                .authoritiesByUsernameQuery("SELECT enduser.email,springrole.role FROM springrole JOIN enduser ON springrole.roleid=enduser.springroleid WHERE enduser.email=?");//this fakes a user role
          
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
				.authorizeRequests()
				.antMatchers("/index.html", "/home.html", "/login.html", "/")
				.authenticated()
					.and()
				.formLogin()
				.loginPage("/login")
				.permitAll();
    	
        http
				.formLogin()
				.loginProcessingUrl("/login");
        http
				.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint);
        http
				.formLogin()
				.successHandler(authenticationSuccessHandler);
        http
				.formLogin()
				.failureHandler(authenticationFailureHandler)
        			.and()
				.headers()
				.cacheControl()
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
    
    /**
	 * Tells the Websecurity to ignore the css, js, and pics folders.
	*/
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/pics/**");

	}

    @Autowired
    private DataSource datasource;

    public void setDatasource(DataSource datasource){
        this.datasource = datasource;
    }


}
