package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.Student;

public interface StudentDAO {
	public void add(Student student);

	public void edit(Student student);

	public void delete(int sid);

	public Student getStudent(int sid);

	@SuppressWarnings("rawtypes")
	public List getAllStudent();
}
