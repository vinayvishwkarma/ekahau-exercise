package com.ekahau.exercise.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ekahau.exercise.model.User;
import com.ekahau.exercise.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	User user = new User("test", "test123");
	
	@Test
	public void test_addUser() {
		user.setId(12345678l);

		when(userRepository.save(user)).thenReturn(user);
		User createdUser = userServiceImpl.saveUser(user);
		assertEquals(user.getId(), createdUser.getId());
		assertEquals(user, createdUser);
	}
	
	@Test
	public void test_getUserByUserName() {
		user.setId(12345678l);

		when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
		User returnedUser = userServiceImpl.findByUserName(user.getUsername());
		assertEquals(user.getId(), returnedUser.getId());
		assertEquals(user, returnedUser);
	}

}
