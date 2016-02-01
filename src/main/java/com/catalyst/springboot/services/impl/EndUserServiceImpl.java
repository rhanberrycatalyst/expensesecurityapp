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

@Service
public class EndUserServiceImpl implements EndUserService {

	@Autowired
	private EndUserDao endUserDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public void setuserDao(EndUserDao userDao) {
		this.endUserDao = userDao;
	}

	@Override
	public List<EndUser> getUsers() {

		List<EndUser> users = endUserDao.getAllEndUsers();
		return users;
	}

	@Override
	public void add(EndUser user) {

		String encryptedPass = encoder.encode(user.getPassword());
		user.setPassword(encryptedPass);
		endUserDao.add(user);
	}

	@Override
	public void update(EndUser user) {
		String oldPassword = endUserDao.getByEndUserId(user.getUserId()).getPassword();
		String newPassword = user.getPassword();

		if (StringUtils.isEmpty(newPassword) || newPassword.equals(oldPassword)) {
			user.setPassword(oldPassword);
		} else if (!encoder.matches(newPassword, oldPassword)) {
			user.setPassword(encoder.encode(newPassword));
		} else {
			user.setPassword(oldPassword);
		}
		endUserDao.update(user);
	}

	@Override
	public EndUser getByUserId(Integer userId) throws InvalidInputException {
		if (userId == null || userId < 0) {
			throw new InvalidInputException("userId.NullOrNegative");
		}
		return endUserDao.getByEndUserId(userId);
	}

	@Override
	public EndUser getUserByUsername(String username) {
		return endUserDao.getEndUserByEndUsername(username);

	}

}
