package com.travis.schoolmanagementapi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travis.schoolmanagementapi.dto.RegisterStudentRequest;
import com.travis.schoolmanagementapi.dto.StudentListRequest;
import com.travis.schoolmanagementapi.dto.SuspendStudentRequest;
import com.travis.schoolmanagementapi.model.Student;
import com.travis.schoolmanagementapi.model.Teacher;
import com.travis.schoolmanagementapi.repo.StudentRepository;
import com.travis.schoolmanagementapi.repo.TeacherRepository;

@RestController
@RequestMapping("/api")
public class AdministratorController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	public AdministratorController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}

	@RequestMapping(value="/students", method=RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}

	@RequestMapping(value="/teachers", method=RequestMethod.POST)
	public void addTeacher(@RequestBody Teacher teacher) {
		teacherRepository.save(teacher);
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public Teacher register(@RequestBody RegisterStudentRequest request) {
		
		Teacher teacher = teacherRepository.findByEmail(request.getTeacher());
		
		List<String> studentToRegister = request.getStudents();
		
		if(teacher != null && !studentToRegister.isEmpty()) {
	
			for(String s : studentToRegister) {
				Student student = new Student();
				student = studentRepository.findByEmail(s);
				
				if(student != null) {
					
					Set<Teacher> assignedTeacher = new HashSet<>(student.getAssignedTeachers());
					assignedTeacher.add(teacher);
					student.setAssignedTeachers(assignedTeacher);
					Set<Student> assignedStudent = new HashSet<>(teacher.getStudentList());
					assignedStudent.add(student);
					teacher.setStudentList(assignedStudent);
					studentRepository.save(student);
				
				}
			}			
			
			return teacherRepository.save(teacher);
			
		}
		
		return null;
	}
	
	
	@RequestMapping(value="/allstudents", method=RequestMethod.GET)
	public List<Student> listAllStudents() {
		return studentRepository.findAll();
	}

	@RequestMapping(value="/allteachers", method=RequestMethod.GET)
	public List<Teacher> listAllTeachers() {
		return teacherRepository.findAll();
	}
	
	@RequestMapping(value="/commonstudents", method=RequestMethod.GET)
	@ResponseBody
	public StudentListRequest commonStudents(@RequestParam String teacher) {
		
		List<String> result = new ArrayList<>();
		List<Teacher> teacherList = teacherRepository.findAll();
		StudentListRequest request = new StudentListRequest();
		
		if(!teacherList.isEmpty()) {
			for(Teacher t: teacherList) {
				if(teacher.equalsIgnoreCase(t.getEmail())) {
					Set<Student> studentList = t.getStudentList();
					
					if(!studentList.isEmpty()) {
						for(Student s : studentList) {
							result.add(s.getEmail());
						}
						request.setStudents(result);
						
						return request;
					}
				}
			}
		}
		
		return null;
	}

	@RequestMapping(value="/suspend", method=RequestMethod.DELETE)
	public void suspend(@RequestBody SuspendStudentRequest request) {
		
		List<Student> studentList = studentRepository.findAll();
		
		if(!studentList.isEmpty()) {
			for(Student s: studentList) {
				if(s.getEmail().equalsIgnoreCase(request.getStudent())) {
					studentRepository.deleteById(s.getId());
					break;
				}
			}
		}
	}
	
}
