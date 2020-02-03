package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
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
	
	@RequestMapping(value="/homepage")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");
		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents.addAll(studentService.getAllStudent());
		
		Map<String, Object> studentsMap = new HashMap<>();
		studentsMap.put("allStudents", listOfStudents);
		mv.addAllObjects(studentsMap);

		return mv;
	}
	
	@RequestMapping(value="/liststudent")
	public String listOfStudent(Model model) {
		Student student = new Student();
		List<Student> allStudents = studentService.getAllStudent();
		model.addAttribute("allStudents", allStudents);
		return "showstudent";
	}
	
	
	
	
	
	
}
