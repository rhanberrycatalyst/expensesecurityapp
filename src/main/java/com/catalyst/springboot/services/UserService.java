package com.catalyst.springboot.services;

import java.util.List;

import com.catalyst.springboot.entities.User;

public interface UserService {

	/**
	 * Add a new user to the application.
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * Update the information in an existing user. The userId is used to
	 * find the unique user's information.
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * Removes the information about an user from the application if their
	 * userId matches.
	 * 
	 * @param userId
	 *            -
	 */
	void delete(Integer userId);

	/**
	 * Retrieve all users from the application.
	 * 
	 * @param isActive
	 *            - optional parameter. If supplied, will only retrieve
	 *            users with matching values. If null, all users are
	 *            returned.
	 * @return
	 */
	List<User> getUsers(Boolean isActive);

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
	User getByUserId(Integer userId) throws InvalidInputException;

	/**
	 * Retrieve a single user's information if that user's username
	 * matches the supplied username.
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

}
