package com.catalyst.springboot.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.NonceExpiredException;

/**
 * The class <code>CustomAuthenticationFailureHandlerTest</code> contains tests for the class <code>{@link CustomAuthenticationFailureHandler}</code>.
 *
 * @generatedBy CodePro at 2/5/16 11:56 AM
 * @author rhanberry
 * @version $Revision: 1.0 $
 */
public class CustomAuthenticationFailureHandlerTest {
	/**
	 * Run the void onAuthenticationFailure(HttpServletRequest,HttpServletResponse,AuthenticationException) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testOnAuthenticationFailure_1()
		throws Exception {
		CustomAuthenticationFailureHandler fixture = new CustomAuthenticationFailureHandler();
		HttpServletRequest request = new HttpServletRequestWrapper(new Request());
		HttpServletResponse response = new HttpServletResponseWrapper(new Response());
		AuthenticationException exception = new NonceExpiredException("");

		fixture.onAuthenticationFailure(request, response, exception);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.apache.catalina.connector.Response.isCommitted(Response.java:612)
		//       at org.apache.catalina.connector.Response.sendError(Response.java:1236)
		//       at javax.servlet.http.HttpServletResponseWrapper.sendError(HttpServletResponseWrapper.java:107)
		//       at com.catalyst.springboot.security.CustomAuthenticationFailureHandler.onAuthenticationFailure(CustomAuthenticationFailureHandler.java:26)
	}

	/**
	 * Run the void onAuthenticationFailure(HttpServletRequest,HttpServletResponse,AuthenticationException) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/5/16 11:56 AM
	 */
	@Test
	public void testOnAuthenticationFailure_2()
		throws Exception {
		CustomAuthenticationFailureHandler fixture = new CustomAuthenticationFailureHandler();
		HttpServletRequest request = new HttpServletRequestWrapper(new Request());
		HttpServletResponse response = new HttpServletResponseWrapper(new Response());
		AuthenticationException exception = new NonceExpiredException("");

		fixture.onAuthenticationFailure(request, response, exception);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at org.apache.catalina.connector.Response.isCommitted(Response.java:612)
		//       at org.apache.catalina.connector.Response.sendError(Response.java:1236)
		//       at javax.servlet.http.HttpServletResponseWrapper.sendError(HttpServletResponseWrapper.java:107)
		//       at com.catalyst.springboot.security.CustomAuthenticationFailureHandler.onAuthenticationFailure(CustomAuthenticationFailureHandler.java:26)
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
		new org.junit.runner.JUnitCore().run(CustomAuthenticationFailureHandlerTest.class);
	}
}