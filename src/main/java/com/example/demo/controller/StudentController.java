package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value ="/addstudent", method=RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student Added";
	}

	@RequestMapping(value ="/getallstudent", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String getAllStudent() {
		
		return studentService.getAllStudent().toString();
	}
	
	@RequestMapping(value ="/getstudentbyid/{studentId}", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String getStudentById(@PathVariable("studentId") int studentId) {
		return studentService.getStudentById(studentId).toString();
		
	}
	
	@RequestMapping(value ="/deletestudent/{studentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteStudentById(@PathVariable ("studentId") int studentId) {
		studentService.deleteStudentById(studentId);
		return "student deleted";
	}
	
	
	@RequestMapping(value ="/updatestudent/{studentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateStudentById(@PathVariable ("studentId") int studentId, @RequestBody Student student) {
		studentService.updateStudentById(studentId, student);
		return "student updated";
	}
	
	
	
	
	
	
}
