package com.ranjan.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ranjan.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	/*
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert();

	}
	*/
	
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Learn JPA", "Ravi Ranjan"));
		courseJdbcRepository.insert(new Course(2, "Learn Hibernate", "Ravi Ranjan"));
		courseJdbcRepository.insert(new Course(3, "Learn JPA and Hibernate", "Ravi Ranjan"));
		
		courseJdbcRepository.deleteById(2);
		
		System.out.println(courseJdbcRepository.findById(1));

	}

}
