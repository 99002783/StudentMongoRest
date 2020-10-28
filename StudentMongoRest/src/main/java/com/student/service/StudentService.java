package com.student.service;

import java.util.List;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	  Student getStudentById(int id)throws StudentNotFoundException;
	  List<Student>getAllStudents();
	  boolean deleteStudentById(int id) throws StudentNotFoundException;

	//Derived queries
	  List<Student> getStudentsByCity(String city) throws StudentNotFoundException;
	  List<Student> getStudentsByDepartment(String department) throws StudentNotFoundException;
}
