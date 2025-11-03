package com.example.demo.Controller;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
// If i used this annotation that time this url common for all
@RequestMapping("/exponent/api/v1")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService us; // autowired userservice

	@PostMapping("/useradd")
	public ResponseEntity<?> userAddController(@RequestBody User user) {

		logger.info("user data is" + user);
		int result = us.addUser(user);
		if (result > 0) {
			return new ResponseEntity("user added successfully", HttpStatus.OK);
		}
		return new ResponseEntity("user added successfully", HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser() {

		List<User> listofUser = us.getAllUserFromService();
		if (listofUser != null) {
			return new ResponseEntity(listofUser, HttpStatus.OK);
		}
		return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getUserBy/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id) {

		User user = us.getUserByIdInService(id);
		if (user != null) {
			return new ResponseEntity(user, HttpStatus.OK);
		}
		return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUserDetails(@RequestBody User user) {

		logger.info("I am in Cotroller layer");

		int result = us.updateUserInService(user);
		if (result > 0) {
			return new ResponseEntity(user, HttpStatus.OK);
		}
		return new ResponseEntity("User not found", HttpStatus.NOT_MODIFIED);
	}

	@PutMapping("/deleteBy/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable String id) {

		logger.info("I am in Cotroller layer");

		int result = us.deletUserByIdInService(id);
		if (result > 0) {
			return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity("User not found", HttpStatus.NO_CONTENT);
	}

}
