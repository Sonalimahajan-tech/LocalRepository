package com.exponent.Dao;

import java.util.List;

import com.exponent.Entity.Student;

public interface StudentDao {

	public Student addStudentDetailsInDao(Student stud);

	public List<Student> getStudentDetailsInDao();

	public void deleteStudentDetailsInDao(int studentID);



}
