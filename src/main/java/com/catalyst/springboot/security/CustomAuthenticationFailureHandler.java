
package com.catalyst.springboot.security;
 

import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;


/**
 * Error handler for Authentication failures.
 * */

public class CustomAuthenticationFailureHandler  implements AuthenticationFailureHandler{

	/**
	 * Handles the unauthenticated resource access  by sending Httperrror 
	 * @param request
	 * @param response
	 * @param exception
	  */
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			   AuthenticationException exception) throws IOException, ServletException {
			  
			  response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
			  
}
}

