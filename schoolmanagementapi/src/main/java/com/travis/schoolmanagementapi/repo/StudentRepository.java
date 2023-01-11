package com.travis.schoolmanagementapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travis.schoolmanagementapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);

}
