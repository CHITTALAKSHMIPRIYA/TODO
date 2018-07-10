package com.bridgelabz.mongo.service;

import java.sql.SQLException;

import com.bridgelabz.mongo.model.User;


public interface UserService {
	public User login(String emailId, String password);
	public boolean register(User user);
}
