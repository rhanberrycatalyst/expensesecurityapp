package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * The following methods map HTML page values. 
 * @author ldahlberg
 * @author gwalpole
 *
 */
@Controller
public class HomeController{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		return "/login.html";
	}
	@RequestMapping(value = "/indexpage", method = RequestMethod.GET)
	public String signin(){
		return "/index.html";
	}
	
}
