package com.example.Service;

import java.util.List;

import com.example.Entity.User;

public interface userService {

	public void adduserInService(User user);

	public void addAlluserInService(List<User> users);
	
	public User getUserInService(int uid);

	public List<User> getAllUserInService();

	public List<User> getAllUserByIdInService(List<Integer> uid);

	public void deleteUserByIdInService(int uid);

	public void deleteAllUserByIdInService(List<Integer> uid);

	public void deleteAllUser();

	public List<User> updateUserById(List<Integer> uid);
	


}
