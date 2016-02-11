package com.catalyst.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
/**
 * The following methods map HTML page values. 
 * @author ldahlberg
 * @author gwalpole
 *
 */
@Controller
public class HomeController{

	@Autowired
	private EndUserService userService;
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index(){
//		return "index.html";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(){
		return "Login/loginIndex.html";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String adduser(@RequestBody EndUser user){
		userService.add(user);
		return "Login/loginIndex.html";
	} 
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public void auth(@RequestBody String username, String password){
//		System.out.println(username + password);
//	}
	
}
