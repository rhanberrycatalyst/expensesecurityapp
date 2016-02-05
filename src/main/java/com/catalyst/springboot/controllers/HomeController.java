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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "/scripts/app/account/login/login.html";
	}
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String index(){
//		return "/index.html";
//	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String projectHome() {
		return "/project-create.html";
	}

	@RequestMapping(value = "/lineitem", method = RequestMethod.GET)
	public String lineItemHome() {
		return "/lineItem-create.html";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String reportHome() {
		return "/report-create.html";
	}

	@RequestMapping(value = "/about-us", method = RequestMethod.GET)
	public String about() {

		return "/about.html";
	}

	@RequestMapping(value = "/employee/index", method = RequestMethod.GET)
	public String employeeIndex() {
		return "/index.html";
	}

	
}
