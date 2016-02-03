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

/**
 * The web service for the End User table's Database access
 * @author ldahlberg
 * @author gwalpole
 */
@RestController
public class EndUserWebService {

	@Autowired
	private EndUserService userService;
	
	/**
	 * Sets a UserService object
	 * @param userService
	 */
	public void setUserService(EndUserService userService) {
		this.userService = userService;
	}

	/**
	 * Adds a new user to the database.
	 * @param user
	 */
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void adduser(@RequestBody EndUser user){
		userService.add(user);
	} 
		
	/**
	 * Returns a list of all the end users.
	 * @return List<EndUser>
	 */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<EndUser> getusers(){
		return userService.getUsers();
	}	
	
    /**
     * Returns the information for an End User corresponding to the passed-in id.
     * @param id
     * @return EndUser
     * @throws InvalidInputException
     */
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public EndUser getUserByID(@PathVariable Integer id) throws InvalidInputException{ 
		return userService.getByUserId(id);
	}
	/**
	 * Edits an existing user in the EndUser table
	 * @param id
	 * @param user
	 */
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void updateuser(@PathVariable Integer id, @RequestBody EndUser user){
		userService.update(user);
	}
}
