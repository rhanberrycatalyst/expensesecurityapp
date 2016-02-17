package com.catalyst.springboot.services.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.EndUserDao;
import com.catalyst.springboot.entities.EndUser;
import com.catalyst.springboot.services.EndUserService;
import com.catalyst.springboot.services.InvalidInputException;

/**
 * The methods declared in this implementation provide basic WebService functionality 
 * @author ldahlberg
 * @author gwalpole
 */
@Service
public class EndUserServiceImpl implements EndUserService {

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * Sets an encoder object
	 * @param encoder
	 */
	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	/**
	 * Sets the userDAO object
	 * @param userDao
	 */
	public void setuserDao(EndUserDao userDao) {
		this.endUserDao = userDao;
	}

	/**
	 * Retrieve all users from the application.
	 * @return
	 */
	@Override
	public List<EndUser> getUsers() {

		List<EndUser> users = endUserDao.getAllEndUsers();
		return users;
	}

	/**
	 * Add a new user to the application.
	 * @param user
	 */
	@Override
	public void add(EndUser user) {

		String encryptedPass = encoder.encode(user.getPassword());
		user.setPassword(encryptedPass);
		endUserDao.add(user);
	}

	/**
	 * Update the information in an existing user. The userId is used to
	 * find the unique user's information.
	 * @param user
	 */
	@Override
	public void update(EndUser user) {
		String oldPassword = endUserDao.getByEndUserId(user.getUserId()).getPassword();
		String newPassword = user.getPassword();

		if (StringUtils.isEmpty(newPassword) || newPassword.equals(oldPassword)) {
			user.setPassword(oldPassword);
		} else  {
			user.setPassword(encoder.encode(newPassword));
		}
		endUserDao.update(user);
	}

	/**
	 * Retrieve a single user's information if that user's userId
	 * matches the supplied userId
	 * @param userId
	 * @return
	 * @throws InvalidInputException
	 *             - the value of userId provided should not be null or less
	 *             than 0
	 */
	@Override
	public EndUser getByUserId(Integer userId) throws InvalidInputException {
		if (userId == null || userId < 0) {
			throw new InvalidInputException("userId.NullOrNegative");
		}
		return endUserDao.getByEndUserId(userId);
	}

	/**
	 * Retrieve a single user's information if that user's username
	 * matches the supplied username.
	 * @param username
	 * @return
	 */
	@Override
	public EndUser getUserByUsername(String email) {
		return endUserDao.getEndUserByEndUsername(email);

	}

}
