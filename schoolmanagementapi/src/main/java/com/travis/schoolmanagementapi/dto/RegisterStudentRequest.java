package com.travis.schoolmanagementapi.dto;

import java.util.List;

public class RegisterStudentRequest {

	private String teacher;
	private List<String> students;
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<String> getStudents() {
		return students;
	}
	public void setStudents(List<String> students) {
		this.students = students;
	}
	

}
