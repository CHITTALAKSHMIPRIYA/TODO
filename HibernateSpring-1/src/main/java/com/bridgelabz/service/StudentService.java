package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.Student;

public interface StudentService {
	public void add(Student student);

	public void edit(Student student);

	public void delete(int sid);

	public Student getStudent(int sid);

	public List getAllStudent();
}
