package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.Student;
@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);

	}

	@Override
	public void delete(int sid) {
		session.getCurrentSession().delete(getStudent(sid));

	}

	@Override
	public List getAllStudent() {

		return session.getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public Student getStudent(int sid) {

		return session.getCurrentSession().get(Student.class, sid);
	}
}
