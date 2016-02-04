package com.catalyst.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

import com.catalyst.springboot.web.filter.CsrfCookieGeneratorFilter;

//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableWebMvcSecurity
//@Configuration
//public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomAuthenticationFailureHandler authenticationFailureHandler;
//
//	@Bean
//	CustomAuthenticationFailureHandler authenticationHandler() {
//		return new CustomAuthenticationFailureHandler();
//	}
//
//	/**
//	 * @param authFailure
//	 *            the authFailure to set
//	 */
//	public void setAuthFailure(CustomAuthenticationFailureHandler authFailure) {
//		this.authenticationFailureHandler = authFailure;
//	}
//
//	@Autowired
//	private CustomLogOutSuccessHandler logoutSuccessHandler;
//
//	@Bean
//	CustomLogOutSuccessHandler logoutSuccessHandler() {
//		return new CustomLogOutSuccessHandler();
//	}
//
//	/**
//	 * @param logoutSuccess
//	 *            the logoutSuccess to set
//	 */
//	public void setLogOutSuccess(CustomLogOutSuccessHandler logoutSuccess) {
//		this.logoutSuccessHandler = logoutSuccess;
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("user").password("root").authorities("user");
//
//		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(encoder())
//				.usersByUsernameQuery("SELECT email,password,isactive FROM enduser WHERE email=?")
//				.authoritiesByUsernameQuery(
//						"SELECT enduser.email,springrole.role FROM enduser JOIN springrole ON enduser.springroleid =springrole.roleid WHERE enduser.email=?");// this
//																																								// fakes
//																																								// a
//																																								// user
//																																								// role
//
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/resources/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/")
//				.permitAll()
//				.defaultSuccessUrl("/index.html")
//				.usernameParameter("username")
//				.passwordParameter("password")
//				.failureHandler(authenticationFailureHandler)
//				.and()
//			.headers()
//				.cacheControl()
//				.and()
//			.logout()
//				.logoutSuccessHandler(logoutSuccessHandler)
//				.logoutSuccessUrl("/")
//				.deleteCookies("JSESSIONID", "CSRF-TOKEN")
//				.permitAll()
//				.and()
//			.csrf().disable();
//
//	}
//
//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	/**
//	 * Tells the Websecurity to ignore the css, js, and pics folders.
//	 */
//	 @Override
//	 public void configure(WebSecurity web) throws Exception {
//	 web.ignoring().antMatchers("resources/css/**", "resources/js/**", "resources/pics/**");
//	
//	 }
//
//	@Autowired
//	private DataSource datasource;
//
//	public void setDatasource(DataSource datasource) {
//		this.datasource = datasource;
//	}
//
//}
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

    

    @Autowired
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Autowired
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Autowired
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

    @Autowired
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

    
    /**
	 * Tells the Websecurity to ignore the css, js, and pics folders.
	 */
	 @Override
	 public void configure(WebSecurity web) throws Exception {
	 web.ignoring().antMatchers("resources/css/**", "resources/js/**", "resources/pics/**").antMatchers("/scripts/**/*.{js,html}")
     .antMatchers("/bower_components/**")
     .antMatchers("/test/**");
	
	 }
    

   

    @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("root").authorities("user");

		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(encoder())
				.usersByUsernameQuery("SELECT email,password,isactive FROM enduser WHERE email=?")
				.authoritiesByUsernameQuery(
						"SELECT enduser.email,springrole.role FROM enduser JOIN springrole ON enduser.springroleid =springrole.roleid WHERE enduser.email=?");// this
																																								// fakes
																																								// a
																																								// user
																																								// role

	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
        .and()
            .addFilterAfter(new CsrfCookieGeneratorFilter(), CsrfFilter.class)
            .exceptionHandling()
            .accessDeniedHandler(new CustomAccessDeniedHandler())
            .authenticationEntryPoint(authenticationEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/authenticate").permitAll()
        .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .successHandler(ajaxAuthenticationSuccessHandler)
            .failureHandler(ajaxAuthenticationFailureHandler)
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler(ajaxLogoutSuccessHandler)
            .deleteCookies("JSESSIONID", "CSRF-TOKEN")
            .permitAll()
        .and()
            .headers()
            .frameOptions()
            .disable();
            

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    

	@Autowired
	private DataSource datasource;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
    
}