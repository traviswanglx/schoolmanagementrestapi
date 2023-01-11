package com.travis.schoolmanagementapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String name;
	
	@ManyToMany(mappedBy="assignedTeachers")
	@JsonIgnore
	@JsonProperty
	private Set<Student> studentList = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

}
