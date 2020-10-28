package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.exception.StudentNotFoundException;
import com.student.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		Student newstudent=studentRepository.save(student);
		return newstudent;
	}

	@Override
	public Student getStudentById(int id) throws StudentNotFoundException {
		return studentRepository.findById(id).orElseThrow(()->
		new StudentNotFoundException("ID Not Found"));
	}

	@Override
	public boolean deleteStudentById(int id) throws StudentNotFoundException{
		studentRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Student> getStudentsByCity(String city) throws StudentNotFoundException {
		return studentRepository.findByAddressCity(city);
	}

	@Override
	public List<Student> getStudentsByDepartment(String department) throws StudentNotFoundException {
		return studentRepository.findByDepartment(department);
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
