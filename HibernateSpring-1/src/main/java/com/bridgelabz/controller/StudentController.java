package com.bridgelabz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/index")
	public String seupFrom(Map<String,Object>map)
	{
		Student student =new Student();
		map.put("student",student);
		map.put("studentList",studentService.getAllStudent());
		return "student";
	}
	public String doActions(@ModelAttribute Student student,BindingResult rs,@RequestParam String action,Map<String,Object>map)
	{
		return "student";
}
}
