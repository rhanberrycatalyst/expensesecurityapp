package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController{

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login()
	{
		return "/login.html";
	}
	
	
	
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
		return "/employee-index.html";
	}

	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	public String employeeCreate() {
		return "/employee-create.html";
	}
	@RequestMapping(value = "/employee/update", method = RequestMethod.GET)
	public String employeeUpdate() {
		return "/employee-update.html";
	}


	@RequestMapping(value = "/employee/delete", method = RequestMethod.GET)
	public String employeeDelete() {
		return "/employee-delete.html";
	}
	
	
}
