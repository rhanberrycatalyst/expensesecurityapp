package com.catalyst.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by rhanberry on 1/25/2016.
 */

//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("root")
//                .authorities("user");
//
//        auth.jdbcAuthentication()
//                .dataSource(datasource)
//                .passwordEncoder(encoder())
//                .usersByUsernameQuery("SELECT username, password, is_active FROM employee WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT username, 'USER' FROM employee WHERE username=?");//this fakes a user role
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.csrf().disable().httpBasic().and().authorizeRequests()
//                .antMatchers("/index.html", "/", "/login.html", "/register.html", "/home.html")
//                .permitAll().anyRequest().authenticated();
//    }
//


    @EnableWebSecurity
    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password("root")
                    .authorities("user");

            auth.jdbcAuthentication()
                    .dataSource(datasource)
                    .passwordEncoder(encoder())
                    .usersByUsernameQuery("SELECT username, password, is_active FROM employee WHERE username=?")
                    .authoritiesByUsernameQuery("SELECT username, 'USER' FROM employee WHERE username=?");//this fakes a user role
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().and().authorizeRequests()
                    .antMatchers("/index.html", "/", "/login.html", "/register.html", "/home.html")
                    .permitAll().anyRequest().authenticated().and().csrf()
                    .csrfTokenRepository(csrfTokenRepository()).and()
                    .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
        }

        private Filter csrfHeaderFilter() {
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request,
                                                HttpServletResponse response, FilterChain filterChain)
                        throws ServletException, IOException {
                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                            .getName());
                    if (csrf != null) {
                        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                        String token = csrf.getToken();
                        if (cookie == null || token != null
                                && !token.equals(cookie.getValue())) {
                            cookie = new Cookie("XSRF-TOKEN", token);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                    }
                    filterChain.doFilter(request, response);
                }
            };
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
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
