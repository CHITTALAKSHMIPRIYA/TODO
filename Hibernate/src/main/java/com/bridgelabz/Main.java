package com.bridgelabz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		try {

			Configuration configure = new Configuration();
			configure.configure("Hibernate.cfg.xml");
			SessionFactory sessionFactory = configure.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Person p = new Person();
			p.setFirstName("chaithra");
			p.setLastName("shenoy");
			p.setMobileNo("987654321");
			p.setId(3);
			session.save(p);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
