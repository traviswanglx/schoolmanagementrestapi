package com.travis.schoolmanagementapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.travis.schoolmanagementapi.controller.AdministratorController;
import com.travis.schoolmanagementapi.dto.RegisterStudentRequest;
import com.travis.schoolmanagementapi.dto.StudentListRequest;
import com.travis.schoolmanagementapi.dto.SuspendStudentRequest;
import com.travis.schoolmanagementapi.model.Student;
import com.travis.schoolmanagementapi.model.Teacher;
import com.travis.schoolmanagementapi.repo.StudentRepository;
import com.travis.schoolmanagementapi.repo.TeacherRepository;

@SpringBootTest
class SchoolmanagementapiApplicationTests {

	@Mock
	private StudentRepository studentRepository;

	@Mock
	private TeacherRepository teacherRepository;
	
	@InjectMocks
	AdministratorController administratorController;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAddStudent() {
		Student s = new Student();
		Mockito.mock(StudentRepository.class);
		Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(s);
		administratorController.addStudent(s);
	}

	@Test
	public void testAddTeacher() {
		Teacher   t = new Teacher();
		Mockito.mock(TeacherRepository.class);
		Mockito.when(teacherRepository.save(Mockito.any(Teacher.class))).thenReturn(t);
		administratorController.addTeacher(t);
	}
	
	@Test
	public void testRegister() {
		
		RegisterStudentRequest request = new RegisterStudentRequest();
		List<String> studentList = new ArrayList<>();
		studentList.add("studentjohn@gmail.com");
		studentList.add("studentdavid@gmail.com");
		
		request.setStudents(studentList);
		request.setTeacher("teachermary@gmail.com");
		
		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("mary");
		teacher.setEmail("teachermary@gmail");
		
		Mockito.when(teacherRepository.findByEmail(Mockito.anyString())).thenReturn(teacher);
		
		Student student = new Student();
		student.setId(1);
		student.setName("name");
		student.setEmail("email");
		
		Mockito.when(studentRepository.findByEmail(Mockito.anyString())).thenReturn(student);
		
		administratorController.register(request);
	}
	
	@Test
	public void testListAllStudent() {
		administratorController.listAllStudents();
	}
	
	@Test
	public void testListAllTeacher() {
		administratorController.listAllTeachers();
	}
	
	@Test
	public void test_commonStudents() {
		String teacherEmail = "teachermary@gmail.com";
		
		Student student = new Student();
		student.setId(1);
		student.setEmail("studentjohn");
		student.setName("john");
		Set<Student> studentList = new HashSet<>();
		studentList.add(student);
		List<Teacher> teacherList = new ArrayList<>();
		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("mary");
		teacher.setEmail("teachermary@gmail.com");
		teacher.setStudentList(studentList);
		teacherList.add(teacher);
		
		Mockito.when(teacherRepository.findAll()).thenReturn(teacherList);
		administratorController.commonStudents(teacherEmail);
		
	}
	
	@Test
	public void testSuspend() {
		
		SuspendStudentRequest request = new SuspendStudentRequest();
		request.setStudent("studentjohn@gmail.com");
		
		List<Student> studentList = new ArrayList<>();
		Student s = new Student();
		s.setId(1);
		s.setEmail("studentjohn@gmail.com");
		s.setName("john");
		studentList.add(s);
		
		Mockito.when(studentRepository.findAll()).thenReturn(studentList);
		
		administratorController.suspend(request);
		
	}
	
	@Test
	public void testTeacherGetIdAndGetName() {
		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("john");
		
		assertEquals(1, teacher.getId());
		assertEquals("john", teacher.getName());
		
	}
	
	@Test
	public void testStudentGetIdAndGetName() {
		Student student = new Student();
		student.setId(1);
		student.setName("john");
		
		assertEquals(1, student.getId());
		assertEquals("john", student.getName());
	}
	
	@Test
	public void testStudentListRequestGetStudents() {
		StudentListRequest s = new StudentListRequest();
		List<String> studentList = new ArrayList<>();
		studentList.add("studentjohn@gmail.com");
		s.setStudents(studentList);
		
		assertEquals(studentList, s.getStudents());
	}
	
	
}
