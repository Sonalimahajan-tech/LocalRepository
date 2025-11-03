package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

	@Autowired
	private UserRepository ur;

	@Override
	public int addUser(User user) {
		logger.info("Now I am in service layer");
		logger.info("Data is:-" + user);

		if (user != null) {
			ur.save(user);
			logger.info("User Added !!!...");
			return 1; // one means true
		}

		return 0;
	}

	@Override
	public List<User> getAllUserFromService() {
		List<User> listofUser = ur.findAll();

//		List<User> listofUser = null;

		if (listofUser != null) {

			return listofUser;

		}
		return null;
	}

	@Override
	public User getUserByIdInService(String id) {
		Optional<User> user = ur.findById(id);
		if (user.isPresent()) {

			return user.get();

		}
		return null;

	}

	@Override
	public int updateUserInService(User user) {
		User u = ur.save(user); // save method working for update and saving purpose
		// so it is called as upsert mathod.
		if (u != null) {
			return 1;

		}
		return 0;
	}

	@Override
	public int deletUserByIdInService(String id) {
		ur.deleteById(id);
		if (ur.findById(id).isPresent()) {

			return 0;

		}
		return 1;
	}

}
