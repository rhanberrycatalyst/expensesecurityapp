package com.catalyst.springboot.daos;

import java.util.List;

import com.catalyst.springboot.entities.User;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to User objects.
 * @author Ernest
 *
 */
public interface UserDao {

	/**
	 * Adds information about an user to storage.
	 * @param user
	 */
	void add(User user);

	/**
	 * Updates the information about an user already in storage.
	 * @param user
	 */
	void update(User user);
	
	/**
	 * Retrieves all users currently in storage.
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 * Retrieve information about a single user from storage with a matching userId
	 * @param userId
	 * @return
	 */
	User getByUserId(Integer userId);

	/**
	 * Deletes information about an user with a matching userId
	 * @param userId
	 */
	void delete(Integer userId);

	/**
	 * Retrieves an user with a matching username.
	 * 
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
	
	

}