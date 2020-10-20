package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.User;
import com.springboot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id, User user) {
		User entity = userRepository.getOne(id);

		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

		return userRepository.save(entity);
	}
}