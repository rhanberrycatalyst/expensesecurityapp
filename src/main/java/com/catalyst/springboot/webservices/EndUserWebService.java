package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
import com.catalyst.springboot.services.InvalidInputException; 

@RestController
public class EndUserWebService {

	@Autowired
	private EndUserService userService;
	
	public void setuserService(EndUserService userService) {
		this.userService = userService;
	}

	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void adduser(@RequestBody EndUser user){
		userService.add(user);
	} 
		
		
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<EndUser> getusers(Boolean active){
		return userService.getUsers(active);
	}	
	

	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public EndUser getuserByID(@PathVariable Integer id) throws InvalidInputException{ 
		return userService.getByUserId(id);
	}
	
	@RequestMapping(value="/userss/{name}", method=RequestMethod.GET)
	public EndUser getByUserName(@PathVariable String name) throws InvalidInputException{ 
		return userService.getUserByUsername(name);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void updateuser(@PathVariable Integer id, @RequestBody EndUser user){
		userService.update(user);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
	public void removeuser(@PathVariable Integer id){
		
		userService.delete(id);
		 
	}
	 
	
	
 
	
 
	
	
	
	
}
