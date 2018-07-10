package com.bridgelabz.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.model.Person;
import com.bridgelabz.mongo.repository.PersonDAO;

@Service
public class PersonService {
	@Autowired(required=true)
private PersonDAO personDAO;
	public Person create(String firstName,String lastName,int age)
	{
		return personDAO.save(new Person(firstName,lastName,age));
	}
	//retrieve
	public List<Person> getAll()
	{
		return personDAO.findAll();
		}
	public Person getByFirstName(String firstName)
	{
		return personDAO.findbyFirstName(firstName);
		
	}
	public Person update(String firstName,String lastName,int age)
	{
		Person p=personDAO.findbyFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personDAO.save(p);
	}
	public void deleteAll()
	{
		personDAO.deleteAll();
	}
	public void delete(String firstName)
	{
		Person p=personDAO.findbyFirstName(firstName);
		personDAO.delete(p);
	}
}
