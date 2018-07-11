package com.bridgelabz.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bridgelabz.mongo.model.User;
import com.bridgelabz.mongo.service.UserServiceImpl;
import com.bridgelabz.mongo.token.TokenGenerator;
import com.bridgelabz.mongo.util.LoginUtility;

@Controller
public class LoginController 
{
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private TokenGenerator token;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/login/")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		if (!userServiceImpl.verifyByuserName(user).get().equals(null)) {
			String validToken = token.generator(user);
			logger.info("Your token: " + validToken);
			token.parseJWT(validToken);
			return new ResponseEntity("Welcome " + user.toString(), HttpStatus.OK);
		}
		return new ResponseEntity(new LoginUtility("Please register!!!Username doesn't exist"), HttpStatus.CONFLICT);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/register/")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		if (!userServiceImpl.verifyEmail(user)) {
			String validToken = token.generator(user);
			logger.info("Your token: " + validToken);
			token.parseJWT(validToken);
			userServiceImpl.saveUser(user);
			return new ResponseEntity("Thanks for registring", HttpStatus.OK);
		}
		return new ResponseEntity(new LoginUtility("username already exists"), HttpStatus.CONFLICT);
	}

}