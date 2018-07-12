package com.bridgelabz.mongo.service;

import java.util.Optional;

import com.bridgelabz.mongo.model.User;

public interface IUserService 
{
	public boolean verifyEmail(User user);
    public User saveUser(User user);
    Optional<User> verifyByuserName(User user);
}
