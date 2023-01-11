package com.travis.schoolmanagementapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String name;
	
	@ManyToMany
	@JoinTable(name="student_teacher", 
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="teacher_id"))
	@JsonIgnore
	private Set<Teacher> assignedTeachers = new HashSet<>();
	
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
	public Set<Teacher> getAssignedTeachers() {
		return assignedTeachers;
	}
	public void setAssignedTeachers(Set<Teacher> assignedTeachers) {
		this.assignedTeachers = assignedTeachers;
	}
	

	
	
	
}
