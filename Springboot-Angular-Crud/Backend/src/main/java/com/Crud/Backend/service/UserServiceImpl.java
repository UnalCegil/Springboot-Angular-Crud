package com.Crud.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Crud.Backend.model.User;
import com.Crud.Backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, long id) {
		
		User u=userRepository.findById(id).get();
		u.setEmail(user.getEmail());
		u.setpNo(user.getpNo());
		u.setAddress(user.getAddress());
		return userRepository.save(u);
	}
	
}
