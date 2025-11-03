package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Student;

public interface StudentService {

	public int addStudent(Student student);

	public List<Student> getAllStudentInService();

	public Student getSingleStudentInService(String sid);

	public int updateStudentFromService(Student student);

	public int deleteStudentFromService(String sid);


}
