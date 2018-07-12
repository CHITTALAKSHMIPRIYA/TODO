package com.bridgelabz.mongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.dao.IUserDAO;
import com.bridgelabz.mongo.model.User;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDAO userDao;

	/**
	 * To verify userName exists in database or not
	 */

	@Override
	public Optional<User> verifyByuserName(User user) {
		return userDao.findById(user.getUserName());
	}

	/** To verify email exists in database or not */
	@Override
	public boolean verifyEmail(User user) {
		if (userDao.existsById(user.getUserName())) {
			return true;
		}
		return false;
	}

	/**
	 * To save user info in database
	 */
	@Override
	public User saveUser(User user) {
		return userDao.insert(user);
	}

	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

}
