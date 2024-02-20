package com.ranjan.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ranjan.springboot.learnjpaandhibernate.course.Course;
import com.ranjan.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.ranjan.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository courseJdbcRepository;
	
//	@Autowired
//	private CourseJpaRepository courseJpaRepository;

	/*
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert();

	}
	*/
	
	/*
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Learn JPA", "Ravi Ranjan"));
		courseJdbcRepository.insert(new Course(2, "Learn Hibernate", "Ravi Ranjan"));
		courseJdbcRepository.insert(new Course(3, "Learn JPA and Hibernate", "Ravi Ranjan"));
		
		courseJdbcRepository.deleteById(2);
		
		System.out.println(courseJdbcRepository.findById(1));

	}
	*/
	
	@Autowired
	private CourseSpringDataJpaRepository courseSpringDataJpaRepository;
	
	/*
	@Override
	public void run(String... args) throws Exception {
		courseJpaRepository.insert(new Course(1, "Learn JPA", "Ravi Ranjan"));
		courseJpaRepository.insert(new Course(2, "Learn Hibernate", "Ravi Ranjan"));
		courseJpaRepository.insert(new Course(3, "Learn JPA and Hibernate", "Ravi Ranjan"));
		
		courseJpaRepository.deleteById(2);
		
		System.out.println(courseJpaRepository.findById(1));

	}
	*/
	@Override
	public void run(String... args) throws Exception {
		courseSpringDataJpaRepository.save(new Course(1, "Learn JPA", "Ravi Ranjan"));
		courseSpringDataJpaRepository.save(new Course(2, "Learn Hibernate", "Ravi Ranjan"));
		courseSpringDataJpaRepository.save(new Course(3, "Learn JPA and Hibernate", "Ravi Ranjan"));
		
		courseSpringDataJpaRepository.deleteById(2l);
		
		courseSpringDataJpaRepository.findByAuthor("Ravi Ranjan");
		
		System.out.println(courseSpringDataJpaRepository.findById(1l));
		System.out.println(courseSpringDataJpaRepository.findAll());

	}

}
