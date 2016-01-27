package com.catalyst.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.daos.UserDao;
import com.catalyst.springboot.entities.User;
import com.catalyst.springboot.services.UserService;
import com.catalyst.springboot.services.InvalidInputException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public void setuserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUsers(Boolean active) {

		List<User> users = userDao.getAllUsers();
		if (active != null) {
			List<User> activeusers = new ArrayList<>();
			for (User e : users) {
				if (e.isActive().equals(active)) {
					activeusers.add(e);
				}
			}
			return activeusers;
		}

		return users;
	}

	@Override
	public void add(User user) {

		String encryptedPass = encoder.encode(user.getPassword());
		user.setPassword(encryptedPass);
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		String oldPassword = userDao.getByUserId(user.getUserId()).getPassword();
		String newPassword = user.getPassword();

		if (StringUtils.isEmpty(newPassword) || newPassword.equals(oldPassword)) {
			user.setPassword(oldPassword);
		} else if (!encoder.matches(newPassword, oldPassword)) {
			user.setPassword(encoder.encode(newPassword));
		} else {
			user.setPassword(oldPassword);
		}
		userDao.update(user);
	}

	@Override
	public User getByUserId(Integer userId) throws InvalidInputException {
		if (userId == null || userId < 0) {
			throw new InvalidInputException("userId.NullOrNegative");
		}
		return userDao.getByUserId(userId);
	}

	@Override
	public void delete(Integer userId) {
		userDao.delete(userId);

	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);

	}

}
