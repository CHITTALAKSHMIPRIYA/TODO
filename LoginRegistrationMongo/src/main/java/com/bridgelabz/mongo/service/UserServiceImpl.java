package com.bridgelabz.mongo.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.dao.UserDAO;
import com.bridgelabz.mongo.dao.UserDAOImpl;
import com.bridgelabz.mongo.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public User login(String emailId, String password) {
		UserDAO repository = new UserDAOImpl();
		User user = repository.getUser(emailId);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean register(User user) {
		UserDAO repository = new UserDAOImpl ();
		User checkUser = repository.getUser(user.getEmailId());
		if(checkUser != null) {
			return false;
		}
		else {
			repository.saveUser(user);
			return true;
		}
	}
}
	
	
