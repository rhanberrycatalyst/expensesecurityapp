package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.entities.User;
import com.catalyst.springboot.services.UserService;
import com.catalyst.springboot.services.InvalidInputException; 

@RestController
public class UserWebService {

	@Autowired
	private UserService userService;
	
	public void setuserService(UserService userService) {
		this.userService = userService;
	}

	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void adduser(@RequestBody User user){
		userService.add(user);
	} 
		
		
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getusers(Boolean active){
		return userService.getUsers(active);
	}	
	

	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User getuserByID(@PathVariable Integer id) throws InvalidInputException{ 
		return userService.getByUserId(id);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void updateuser(@PathVariable Integer id, @RequestBody User user){
		userService.update(user);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
	public void removeuser(@PathVariable Integer id){
		
		userService.delete(id);
		 
	}
	 
	
	
 
	
 
	
	
	
	
}
