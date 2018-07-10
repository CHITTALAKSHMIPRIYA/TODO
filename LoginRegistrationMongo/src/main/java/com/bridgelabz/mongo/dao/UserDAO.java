package com.bridgelabz.mongo.dao;

import com.bridgelabz.mongo.model.User;
import com.mongodb.DBCollection;



public interface UserDAO {
	public DBCollection getCollection();
	public User getUser(String email);
	public void saveUser(User user);
}