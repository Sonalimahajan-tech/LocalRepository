package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.User;
import com.example.Service.userService;

@RestController
public class HomeController {
	
	@Autowired
	private userService us;
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody User user) {
		
		us.adduserInService(user);
		
	}


	@PostMapping("/addalluser")
	public void addAllUsers(@RequestBody List<User> users) {
		
		us.addAlluserInService(users);
		
		System.out.println("Added All User");
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam int uid) {
		
		User user = us.getUserInService(uid);
		System.out.println(user);
		return user;
	}
	
	@GetMapping("/getall")
	public List<User> getAllUsers() {
		
	List<User> userlist = us.getAllUserInService();
		
		return userlist;
	}
	
	@GetMapping("/getAllUserById")
	public List<User> getAllUserById(@RequestParam List<Integer> uid) {
		
		List<User> userlist = us.getAllUserByIdInService(uid);
		
		return userlist;
	}
	
	@DeleteMapping("/delete/{uid}")
	public void deleteUserById(@PathVariable int uid) {
		
		us.deleteUserByIdInService(uid);
		
	}
	
	@DeleteMapping("/deleteAllById")
	public void deleteAllById(@RequestBody List<Integer> uid) {
		
		us.deleteAllUserByIdInService(uid);
	}
	
	public void deleteAll() {
		
		us.deleteAllUser();
	}
	
	@PutMapping("/updateUser")
	public List<User> updateUserById(@RequestBody List<Integer> uid) {
	
	List<User> userlist = us.updateUserById(uid);
	return userlist;
	
}
}