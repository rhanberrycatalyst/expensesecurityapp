package com.catalyst.springboot.security;

import java.util.Map;
import javassist.scopedpool.SoftValueHashMap;
import javax.sql.DataSource;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.bm.cfg.Ejb3UnitCfg;
import com.bm.utils.BasicDataSource;

/**
 * The class <code>SpringSecurityConfigurerTest</code> contains tests for the class <code>{@link SpringSecurityConfigurer}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:56 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class SpringSecurityConfigurerTest {
	/**
	 * Run the CustomAuthenticationFailureHandler authenticationHandler() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testAuthenticationHandler_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());

		CustomAuthenticationFailureHandler result = fixture.authenticationHandler();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_2()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_3()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_4()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_5()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(AuthenticationManagerBuilder) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_6()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null);

		fixture.configure(auth);

		// add additional test code here
	}

	/**
	 * Run the void configure(HttpSecurity) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_7()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		HttpSecurity http = new HttpSecurity((ObjectPostProcessor<Object>) null, new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null), new SoftValueHashMap());

		fixture.configure(http);

		// add additional test code here
	}

	/**
	 * Run the void configure(HttpSecurity) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_8()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		HttpSecurity http = new HttpSecurity((ObjectPostProcessor<Object>) null, new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null), new SoftValueHashMap());

		fixture.configure(http);

		// add additional test code here
	}

	/**
	 * Run the void configure(HttpSecurity) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_9()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		HttpSecurity http = new HttpSecurity((ObjectPostProcessor<Object>) null, new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null), new SoftValueHashMap());

		fixture.configure(http);

		// add additional test code here
	}

	/**
	 * Run the void configure(HttpSecurity) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_10()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		HttpSecurity http = new HttpSecurity((ObjectPostProcessor<Object>) null, new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null), new SoftValueHashMap());

		fixture.configure(http);

		// add additional test code here
	}

	/**
	 * Run the void configure(HttpSecurity) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConfigure_11()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		HttpSecurity http = new HttpSecurity((ObjectPostProcessor<Object>) null, new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) null), new SoftValueHashMap());

		fixture.configure(http);

		// add additional test code here
	}

	/**
	 * Run the BCryptPasswordEncoder encoder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testEncoder_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());

		BCryptPasswordEncoder result = fixture.encoder();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the CustomLogOutSuccessHandler logoutSuccessHandler() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testLogoutSuccessHandler_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());

		CustomLogOutSuccessHandler result = fixture.logoutSuccessHandler();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setAuthFailure(CustomAuthenticationFailureHandler) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testSetAuthFailure_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		CustomAuthenticationFailureHandler authFailure = new CustomAuthenticationFailureHandler();

		fixture.setAuthFailure(authFailure);

		// add additional test code here
	}

	/**
	 * Run the void setDatasource(DataSource) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testSetDatasource_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		DataSource datasource = new BasicDataSource(Ejb3UnitCfg.getConfiguration());

		fixture.setDatasource(datasource);

		// add additional test code here
	}

	/**
	 * Run the void setLogOutSuccess(CustomLogOutSuccessHandler) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testSetLogOutSuccess_1()
		throws Exception {
		SpringSecurityConfigurer fixture = new SpringSecurityConfigurer();
		fixture.setLogOutSuccess(new CustomLogOutSuccessHandler());
		fixture.setDatasource(new BasicDataSource(Ejb3UnitCfg.getConfiguration()));
		fixture.setAuthFailure(new CustomAuthenticationFailureHandler());
		CustomLogOutSuccessHandler logoutSuccess = new CustomLogOutSuccessHandler();

		fixture.setLogOutSuccess(logoutSuccess);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SpringSecurityConfigurerTest.class);
	}
}