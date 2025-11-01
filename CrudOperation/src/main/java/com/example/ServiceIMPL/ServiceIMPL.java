package com.example.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Entity.User;
import com.example.Repository.userRepo;
import com.example.Service.userService;

@Service
public class ServiceIMPL implements userService {

	@Autowired
	private userRepo ur;

	@Override
	public void adduserInService(User user) {
		System.out.println(user);
		ur.save(user);

	}

	@Override
	public void addAlluserInService(List<User> users) {
		ur.saveAll(users);

	}

	@Override
	public User getUserInService(int uid) {
		User user = ur.getById(uid);
		return user;
	}

	@Override
	public List<User> getAllUserInService() {

		List<User> userlist = ur.findAll();
		return userlist;

	}

	@Override
	public List<User> getAllUserByIdInService(List<Integer> uid) {
		List<User> userlist = ur.findAllById(uid);

		return userlist;
	}

	@Override
	public void deleteUserByIdInService(int uid) {

		ur.deleteById(uid);

	}

	@Override
	public void deleteAllUserByIdInService(List<Integer> uid) {
		ur.deleteAllById(uid);

	}

	@Override
	public void deleteAllUser() {
		ur.deleteAll();

	}

	@Override
	public List<User> updateUserById(@RequestBody List<Integer> uid) {

		List<User> userlist = ur.findAllById(uid);

		for (User user : userlist) {
			user.setName(user.getName());
			user.setAddress(user.getAddress());
			user.setMbno(user.getMbno());
			ur.save(user);
			
		}
		return userlist;
	
	}

}
