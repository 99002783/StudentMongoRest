package com.student.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;


	import com.student.model.Student;
	import com.student.service.StudentService;

	@RestController
	@RequestMapping("/student-api")
	public class StudentController {
		@Autowired
		StudentService studentService;
		@PostMapping("/students")
		ResponseEntity<Student> addStudent(@RequestBody Student student) {
			Student newstudent= studentService.addStudent(student);
			return ResponseEntity.ok(newstudent);
		}
		@GetMapping("/students")
		List<Student> getAllStudents(){
			return studentService.getAllStudents();
		}
		
		@GetMapping("/student-by-id/{id}")
		ResponseEntity<Student> getStudentById(@PathVariable("id")int id){
			Student student=studentService.getStudentById(id);
			return ResponseEntity.ok(student);
		}
		@GetMapping("/students-by-dept/{department}")
		ResponseEntity<List<Student>> getStudentByDept(@PathVariable("dept")String department){
			List<Student> students=studentService.getStudentsByDepartment(department);
			return ResponseEntity.ok(students);
		}
		@GetMapping("/students-by-city/{city}")
		ResponseEntity<List<Student>> getStudentByCity(@PathVariable("city")String city){
			List<Student> students=studentService.getStudentsByCity(city);
			return ResponseEntity.ok(students);
		}
		@GetMapping("/delete-one/{id}")
		boolean deleteStudent(@PathVariable("id")int id) throws com.student.exception.StudentNotFoundException{
			studentService.deleteStudentById(id);
			return true;
		}
	}

