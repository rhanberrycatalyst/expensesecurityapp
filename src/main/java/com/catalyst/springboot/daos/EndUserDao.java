package com.catalyst.springboot.daos;

import java.util.List;

import com.catalyst.springboot.entities.EndUser;

/**
 * The methods declared in this interface are to provide basic CRUD functionality related to endUser objects.
 * @author Ernest
 *
 */
public interface EndUserDao {

	/**
	 * Adds information about an endUser to storage.
	 * @param endUser
	 */
	void add(EndUser endUser);

	/**
	 * Updates the information about an endUser already in storage.
	 * @param endUser
	 */
	void update(EndUser endUser);
	
	/**
	 * Retrieves all endUsers currently in storage.
	 * @return
	 */
	List<EndUser> getAllEndUsers();
	
	/**
	 * Retrieve information about a single endUser from storage with a matching endUserId
	 * @param endUserId
	 * @return
	 */
	EndUser getByEndUserId(Integer endUserId);

	/**
	 * Retrieves an endUser with a matching endUsername.
	 * 
	 * @param endUsername
	 * @return
	 */
	EndUser getEndUserByEndUsername(String endUsername);
	
}