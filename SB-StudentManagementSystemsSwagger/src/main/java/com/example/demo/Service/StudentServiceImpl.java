package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.AprEndpoint.Sendfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.controller.StudentController;

@Service
public class StudentServiceImpl implements StudentService {

	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository sr;

	@Autowired
	private JavaMailSender jm;

	@Override
	public int addStudent(Student student) {

		logger.info("I am in service layer");
		logger.info("Student Data is:-" + student);

		if (student != null) {
			sr.save(student);
			logger.info("Student Added Successfully");
			return 1;

		}
		return 0;
	}

	@Override
	public List<Student> getAllStudentInService() {
		List<Student> allStudent = sr.findAll();

		if (allStudent != null) {

			SimpleMailMessage sms = new SimpleMailMessage();
			sms.setTo("sonalipatil35435@gmail.com");
			sms.setSubject("ALL STUDENT DATA");
			sms.setText("Hi Gm!!! ...Hope u r doing well.I am a java developer" + allStudent);

			jm.send(sms);

			return allStudent;

		}
		return null;
	}

	@Override
	public Student getSingleStudentInService(String sid) {
		Optional<Student> student = sr.findById(sid);
		if (student.isPresent()) {

			return student.get();

		}
		return null;
	}

	@Override
	public int updateStudentFromService(Student student) {
		Student updatedstud = sr.save(student);
		if (updatedstud != null) {
			return 1;

		}
		return 0;
	}

	@Override
	public int deleteStudentFromService(String sid) {
		sr.deleteById(sid);
		if (sr.findById(sid).isPresent()) {
			return 0;
		}
		return 1;
	}

}
