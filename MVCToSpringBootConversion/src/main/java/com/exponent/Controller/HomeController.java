package com.exponent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exponent.Entity.Student;
import com.exponent.Service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService std;

	private final static String PASSWORD = "Sonali1234";

	@RequestMapping(value = "/reg")
	public String getReg(@ModelAttribute Student stud, Model model) {
		Student student = std.addStudentDetails(stud);
		System.out.println(student);
		model.addAttribute("addstd", student);
		if (student != null) {
			return "login";

		} else {
			return "register";
		}
	}

	@RequestMapping(value = "/log")
	public String getStudentDetailsFromSID(@RequestParam("Username") String un, @RequestParam("Password") String ps,
			Model model) {
		List<Student> liststd = std.getStudentDetails();
		System.out.println(liststd);

		boolean flag = false;
		for (Student student : liststd) {
			if (student != null && student.getSusername().equals(un) && PASSWORD.equals(ps)) {
				flag = true;
				break;

			}
		}
		if (flag) {
			model.addAttribute("getStd", liststd);
			return "success";

		} else {
			model.addAttribute("getStd", "Invalid Username please Re-Enter");
			return "login";
		}
	}

	@RequestMapping(value = "/del")
	public String deleteStudentDetailsFromSID(@RequestParam("sid") int studentID, Model model) {
		System.out.println("Now I am in controller layer");
		System.out.println("Student Id from backend" + studentID);
		std.deleteStudentDetails(studentID);
		List<Student> studentDetails = std.getStudentDetails();
		model.addAttribute("getStd", studentDetails);
		return "success";

	}
}
