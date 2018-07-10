package com.bridgelabz.mongo.util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class LoginUtility {
	public static DBCollection getCollection()
	{
		//create mongo client
		System.out.println("create connection with mongodb server");
		  MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		  System.out.println("connection established");
		  
		  //connecting with database
		  System.out.println("connecting with db");
		  DB db=mongo.getDB("todo");
		  System.out.println("connectedc with db");
		  System.out.println("Database name:"+db.getName());
		  //creating a collection
		  DBCollection coll=db.getCollection("User");
		  System.out.println("collection created");
		return coll;
	}

}
