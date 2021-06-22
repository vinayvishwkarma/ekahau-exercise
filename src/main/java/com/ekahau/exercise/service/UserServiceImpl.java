package com.ekahau.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ekahau.exercise.model.User;
import com.ekahau.exercise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No user " + "Found with username : " + username));
		return user;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);

	}

}
