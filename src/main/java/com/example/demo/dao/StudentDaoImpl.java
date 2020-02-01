package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("jdbcTemplateName")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Optional<Student> getStudentById(int studentId) {
		String sql = "select name, age from student where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {studentId},
				(rs, rowNum) -> Optional.of(new Student(
						rs.getString("name"),
						rs.getInt("age")
						))
				);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudents = new ArrayList<>();
		allStudents.addAll((Collection<? extends Student>) jdbcTemplate.queryForList("select * from student"));
		return allStudents;
	}

	@Override
	public void addStudent(Student student) {
		String addQuery = "insert into student (name, age) values (?,?)";
		jdbcTemplate.update(addQuery, student.getName(), student.getAge());
		
	}

	@Override
	public void deleteStudentById(int studentId) {
		String deleteQuery = "delete from student where id = ?";
		jdbcTemplate.update(deleteQuery, studentId);
		
	}

	@Override
	public void updateStudentById(int studentId, Student student) {
		String updateQueryString = "update student set name = ?, age = ? where id = ?";
		jdbcTemplate.update(updateQueryString, student.getName(), student.getAge(), studentId);
	}

}
