package com.catalyst.springboot.services;

import java.util.List;

import com.catalyst.springboot.entities.EndUser;

/**
 * The methods declared in this interface are to provide basic WebService functionality 
 * @author ldahlberg
 * @author gwalpole
 */
public interface EndUserService {

	/**
	 * Add a new user to the application.
	 * 
	 * @param user
	 */
	void add(EndUser user);

	/**
	 * Update the information in an existing user. The userId is used to
	 * find the unique user's information.
	 * 
	 * @param user
	 */
	void update(EndUser user);

	/**
	 * Retrieve all users from the application.
	 * 
	 * @param isActive
	 *            - optional parameter. If supplied, will only retrieve
	 *            users with matching values. If null, all users are
	 *            returned.
	 * @return
	 */
	List<EndUser> getUsers();

	/**
	 * Retrieve a single user's information if that user's userId
	 * matches the supplied userId
	 * 
	 * @param userId
	 * @return
	 * @throws InvalidInputException
	 *             - the value of userId provided should not be null or less
	 *             than 0
	 */
	EndUser getByUserId(Integer userId) throws InvalidInputException;

	/**
	 * Retrieve a single user's information if that user's username
	 * matches the supplied username.
	 * 
	 * @param username
	 * @return
	 */
	EndUser getUserByUsername(String username);

}
