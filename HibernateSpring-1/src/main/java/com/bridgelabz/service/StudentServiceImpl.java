package com.bridgelabz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bridgelabz.dao.StudentDAO;
import com.bridgelabz.model.Student;

@Service
public class StudentServiceImpl {
	private StudentDAO studentDAO;

	@Transactional

	public void add(Student student) {
		studentDAO.add(student);

	}

	@Transactional
	public void edit(Student student) {
		studentDAO.edit(student);

	}

	@Transactional
	public void delete(int sid) {
		studentDAO.delete(sid);

	}

	@Transactional
	public Student getStudent(int sid) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(sid);
	}

	public List getAllStudent() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudent();
	}
}
