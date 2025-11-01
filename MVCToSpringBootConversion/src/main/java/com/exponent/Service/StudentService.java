package com.exponent.Service;

import java.util.List;

import com.exponent.Entity.Student;

public interface StudentService {

	public Student addStudentDetails(Student stud);

	public List<Student> getStudentDetails();

	public void deleteStudentDetails(int studentID);

}
