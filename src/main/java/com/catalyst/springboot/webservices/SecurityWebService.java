package com.catalyst.springboot.webservices;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
/**
 * Web Service to get the current user who is logged in.
 * @author apaulose
 *
 */
@RestController
public class SecurityWebService {
	@Autowired
	private EndUserService endUserService;
	public void setEmployeeService(EndUserService endUserService)
	{
		this. endUserService=endUserService;
	}
	
	@RequestMapping(value="/security/current",method=RequestMethod.GET)
		public EndUser currentUser(Principal principal){
			if (principal == null) {
				System.out.println("No value passed");
			}
		System.out.println("principal"+principal);
		System.out.println("principalname"+principal.getName());
		return  endUserService.getUserByUsername(principal.getName());
	}
	@RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	
//	
//	@RequestMapping(value="/authentication", method=RequestMethod.POST)
//	public EndUser loggingUser(@RequestBody String email, String password){
//		return endUserService.getUserByUsername(email);
//	}

}
