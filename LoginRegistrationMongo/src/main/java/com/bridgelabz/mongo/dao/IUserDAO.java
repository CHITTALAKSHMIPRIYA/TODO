package com.bridgelabz.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.mongo.model.User;

@Repository
public interface IUserDAO extends MongoRepository<User, String> {

	User findByEmail(String email);

}
