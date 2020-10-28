package com.student.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {
	
	 List<Student>findByAddressCity(String city) throws StudentNotFoundException;
	  List<Student> findByDepartment(String department) throws StudentNotFoundException;

}
