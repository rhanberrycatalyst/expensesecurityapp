package com.catalyst.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebMvcSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationFailureHandler authFailure;

	@Bean
	CustomAuthenticationFailureHandler authenticationHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	/**
	 * @param authFailure
	 *            the authFailure to set
	 */
	public void setAuthFailure(CustomAuthenticationFailureHandler authFailure) {
		this.authFailure = authFailure;
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

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("root").authorities("user");

		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(encoder())
				.usersByUsernameQuery("SELECT email,password,isactive FROM enduser WHERE email=?")
				.authoritiesByUsernameQuery(
						"SELECT enduser.email,springrole.role FROM enduser JOIN springrole ON enduser.springroleid =springrole.roleid WHERE enduser.email=?");																																																																																																																																			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.anyRequest().authenticated()
	    	.and()
	    .formLogin()
			.loginPage("/loginPage")
			.permitAll()
			.loginProcessingUrl("/loginPage")
			.defaultSuccessUrl("/")
			.usernameParameter("username")
			.passwordParameter("password")
			.failureHandler(authFailure)
			.and()
	.headers()
		.cacheControl()
		.and()
	.logout()
		.logoutSuccessHandler(logoutSuccessHandler) 
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID", "CSRF-TOKEN")
		.permitAll()
		.and()
	.csrf().disable();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Tells the Websecurity to ignore the css, js, and pics folders.
	 */

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        	.antMatchers("/login/**")
            .antMatchers("/css/**")
            .antMatchers("/js/**");
    }
 

	@Autowired
	private DataSource datasource;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}
