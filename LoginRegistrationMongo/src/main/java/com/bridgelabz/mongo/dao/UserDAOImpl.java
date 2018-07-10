package com.bridgelabz.mongo.dao;

import org.springframework.stereotype.Repository;

import com.bridgelabz.mongo.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
@Repository
public class UserDAOImpl implements UserDAO{

	@Override
	public DBCollection getCollection() {
		//Create connection
		System.out.println("Creating connectins with MongoDB server");
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Connection established");
		
		//Connecting with Database
		System.out.println("Connecting with Database");
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("UserDatabase");
		System.out.println("Connected with Database");
		System.out.println("Database name:- " + db.getName());
		
		//Create collection
		DBCollection collection = db.getCollection("UserInformation");
		System.out.println("Collection created");
		
		return collection;
	}
	
	@Override
	public User getUser(String email) {
		DBCollection collection = getCollection();
		System.out.println("Finding User for login");
		
		BasicDBObject object = new BasicDBObject("emailId", email);
		Cursor cursor = collection.find(object);
		
		while(cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			if(obj.get("emailId").toString().equals(email)) {
				User user = new User();
				user.setUserId(obj.getInt("userId"));
				user.setUserName(obj.getString("userName"));
				user.setEmailId(obj.getString("emailId"));
				user.setPassword(obj.getString("password"));
				user.setPhoneNumber(obj.getLong("phoneNumber"));
				return user;
			}
		}
		return null;
	}
	
	@Override
	public void saveUser(User user) {
		DBCollection collection = getCollection();
		System.out.println("Finding user for registration");
		
		BasicDBObject object = new BasicDBObject("userId", user.getUserId()).
				append("userName", user.getUserName()).
				append("emailId", user.getEmailId()).
				append("password", user.getPassword()).
				append("phoneNumber", user.getPhoneNumber());
		collection.insert(object);
		System.out.println("Document inserted");
	}
}


