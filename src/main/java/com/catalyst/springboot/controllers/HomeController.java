package com.catalyst.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String projectHome() {
		return "/project-create.html";
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

	// Match everything without a suffix (so not a static resource)
	@RequestMapping(value = "/{[path:[^\\.]*}")
	public String redirect() {
		// Forward to home page so that route is preserved.
		return "forward:/";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}


}
