package com.travis.schoolmanagementapi.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentListRequest {

	private List<String> students = new ArrayList<>();

	public List<String> getStudents() {
		return students;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	};
	
	
	
}
