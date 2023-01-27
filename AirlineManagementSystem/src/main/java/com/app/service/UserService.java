package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.User;

@Service
public interface UserService {

	public String addUser(User user);

	public List<User> fetchAllUsers();

	public Optional<User> fetchUserById(Long userId);

	public User updateUserDetails(User user);

	public String deleteUser(Long userId);
}
