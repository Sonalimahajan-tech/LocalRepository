package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;

public interface UserService {
	
	public int addUser(User user);

	public List<User> getAllUserFromService();
	
	public User getUserByIdInService(String id);

	public int updateUserInService(User user);

	public int deletUserByIdInService(String id);

	



}
