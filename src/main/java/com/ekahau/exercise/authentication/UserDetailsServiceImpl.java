package com.ekahau.exercise.authentication;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ekahau.exercise.model.User;
import com.ekahau.exercise.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No user " + "Found with username : " + username));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.emptyList());
	}
}
