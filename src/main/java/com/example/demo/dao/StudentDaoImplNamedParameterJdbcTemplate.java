package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


@Repository("namedParameter")
public class StudentDaoImplNamedParameterJdbcTemplate implements StudentDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Optional<Student> getStudentById(int studentId) {
		String sql = "select name, age from student where id = :key";
		SqlParameterSource paramMap = new MapSqlParameterSource("key", studentId);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, (rs, rowNum)-> Optional.of(
				new Student(
						rs.getString("name"),
						rs.getInt("age"))
				));
	}

	@Override
	public List<Student> getAllStudent() {
		String selectSql = "select * from student";
		return (List<Student>) namedParameterJdbcTemplate.query(selectSql, new StudentMapper());
		
	}

	@Override
	public void addStudent(Student student) {
		String addStudentSQL = "insert into student (age, name) values (:keyAge, :keyName)";
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("keyAge", student.getAge());
		paraMap.put("keyName", student.getName());
		namedParameterJdbcTemplate.update(addStudentSQL, paraMap);
		
	}

	@Override
	public void deleteStudentById(int studentId) {
		String deleteStudentSql = "delete from student where id = :keyStudentId";
		SqlParameterSource paramSource = new MapSqlParameterSource("keyStudentId", studentId);
		namedParameterJdbcTemplate.update(deleteStudentSql, paramSource);
		
	}

	@Override
	public void updateStudentById(int studentId, Student student) {
		String updateStudentSql = "update student set age = :keyStudentAge , name = :keyStudentName where id = :keyStudentId";
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("keyStudentAge", student.getAge());
		paraMap.put("keyStudentName", student.getName());
		paraMap.put("keyStudentId", studentId);
		namedParameterJdbcTemplate.update(updateStudentSql, paraMap);
		
		
	}
	
	private final static class StudentMapper implements RowMapper<Student>, SqlParameterSource{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setAge(rs.getInt("age"));
			student.setName(rs.getString("name"));
			return student;
		}

		@Override
		public boolean hasValue(String paramName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValue(String paramName) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
