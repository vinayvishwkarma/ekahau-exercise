package com.ekahau.exercise.service;

import com.ekahau.exercise.model.User;

public interface UserService {
	public User findByUserName(String username);

	public User saveUser(User user);

}
