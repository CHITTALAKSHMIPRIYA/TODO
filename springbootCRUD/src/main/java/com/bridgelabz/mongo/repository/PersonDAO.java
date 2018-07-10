package com.bridgelabz.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.mongo.model.Person;

@Repository
public interface PersonDAO extends MongoRepository<Person,String> {
	public Person findbyFirstName(String firstName);
	public List<Person> findByAge(int age);

}
