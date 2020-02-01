package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	private int id;
	private String name;
	private int age;
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	
	public Student(@JsonProperty String name,@JsonProperty int age) {
		super();
		this.name = name;
		this.age = age;
	}



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}



	public void setAge(int age) {
		this.age = age;
	}
	
	

}
