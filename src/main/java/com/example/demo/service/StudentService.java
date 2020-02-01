package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentService {
	
	
	private final StudentDao studentDao;
	
	@Autowired
	public StudentService(@Qualifier("namedParameter") StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	
	public List<Student> getAllStudent(){
		return studentDao.getAllStudent();
	}
	
	public Optional<Student> getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);
		
	}

	public void updateStudentById(int studentId, Student student) {
		studentDao.updateStudentById(studentId, student);
	}

}
