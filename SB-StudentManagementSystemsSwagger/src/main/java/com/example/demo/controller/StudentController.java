package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("exponent/api")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService ss;

	@PostMapping("/addData")
	public ResponseEntity<?> addStudentDetails(@RequestBody Student student) {
		logger.info("Student Data is:" + student);
		int result = ss.addStudent(student);
		if (result > 0) {

			return new ResponseEntity("Data Added Successfully", HttpStatus.OK);

		}

		return new ResponseEntity("Student Not Found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllData")
	public ResponseEntity<?> getAllStudent() {

		List<Student> allStudent = ss.getAllStudentInService();
		if (allStudent != null) {

			return new ResponseEntity(allStudent, HttpStatus.OK);

		}

		return new ResponseEntity("Student Not Found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getDataBy/{sid}")
	public ResponseEntity<?> getStudentById(@PathVariable String sid) {

		Student student = ss.getSingleStudentInService(sid);
		if (student != null) {

			return new ResponseEntity(student, HttpStatus.OK);

		}

		return new ResponseEntity("Student Not Found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatestudent")
	public ResponseEntity<?> updateStudentDetails(@RequestBody Student student) {

		int Result = ss.updateStudentFromService(student);
		if (Result > 0) {

			return new ResponseEntity(student, HttpStatus.OK);

		}

		return new ResponseEntity("Student Not Found", HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping("/deletestudent{sid}")
	public ResponseEntity<?> deleteStudentById(@PathVariable String sid) {
		logger.info("I am in Cotroller layer");
		int Result = ss.deleteStudentFromService(sid);
		if (Result > 0) {

			return new ResponseEntity("Student Deleted Successfully", HttpStatus.OK);

		}

		return new ResponseEntity("Student Not Found", HttpStatus.NOT_MODIFIED);
	}
}
