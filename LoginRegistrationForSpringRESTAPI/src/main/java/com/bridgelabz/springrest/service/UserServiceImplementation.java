package com.bridgelabz.springrest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springrest.dao.UserDAO;
import com.bridgelabz.springrest.dao.UserDAOIMpl;
import com.bridgelabz.springrest.model.User;



@Service
public class UserServiceImplementation implements UserService  {

	//@Autowired
	UserDAO userDAO=new UserDAOIMpl(); 
		
	

	public int verifyUser(User user) throws ClassNotFoundException, SQLException {
		User userReturn = userDAO.getUserByUserName(user.getUserName());
		if (userReturn != null) {
			if (userReturn.getPassword().equals(user.getPassword())) {
				System.out.println("pass match");
				return 1;
			} else {
				return 0;
			}
		}
		return -1;
		}

	
	public  boolean verifyEmail(User user) throws ClassNotFoundException, SQLException {
		if(userDAO.getUserByUserEmail(user.getEmail())) {
			return true;
		}
		return false;
		}


	public void saveUser(User user) throws ClassNotFoundException, SQLException {
		userDAO.saveUser(user);
		
	}


}

