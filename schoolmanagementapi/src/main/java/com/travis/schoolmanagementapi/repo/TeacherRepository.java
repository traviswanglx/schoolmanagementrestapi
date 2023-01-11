package com.travis.schoolmanagementapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travis.schoolmanagementapi.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	Teacher findByEmail(String email);

}
