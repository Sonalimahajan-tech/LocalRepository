package com.exponent.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exponent.Entity.Student;

@Repository
public class StudentDaoIMPL implements StudentDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Student addStudentDetailsInDao(Student stud) {
		System.out.println("Now I am in dao layer");
		Session session = sf.openSession();
		System.out.println(stud);
		session.save(stud);
		session.beginTransaction().commit();
		System.out.println("Data Inserted Successfully");
		return stud;

	}

	@Override
	public List<Student> getStudentDetailsInDao() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Student");
		return query.getResultList();

	}

	@Override
	public void deleteStudentDetailsInDao(int studentID) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Student where sid=:studentID");
		query.setParameter("studentID", studentID);
		query.executeUpdate();
		tx.commit();
		System.out.println("Data Deleted Successfully");

	}

}
