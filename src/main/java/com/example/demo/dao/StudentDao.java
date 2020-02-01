package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


@Repository
public interface StudentDao {
	
	Optional<Student> getStudentById(int studentId);
	
	List<Student> getAllStudent();
	
	void addStudent(Student student);

	void deleteStudentById(int studentId);

	void updateStudentById(int studentId, Student student);
	
	

}
