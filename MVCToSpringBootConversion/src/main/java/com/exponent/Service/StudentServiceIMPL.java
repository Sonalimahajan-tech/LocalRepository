package com.exponent.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exponent.Dao.StudentDao;
import com.exponent.Entity.Student;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentDao stdd;

	@Override
	public Student addStudentDetails(Student stud) {

		System.out.println("Now I am in service layer");

		return stdd.addStudentDetailsInDao(stud);
	}

	@Override
	public List<Student> getStudentDetails() {
		return stdd.getStudentDetailsInDao();

	}

	@Override
	public void deleteStudentDetails(int studentID) {
		stdd.deleteStudentDetailsInDao(studentID);
		
	}

}
