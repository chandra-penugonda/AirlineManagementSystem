package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.UserSearchCriteria;
import com.app.model.User;

@Service
public interface UserService {

	public String addUser(User user);

	public Page<User> fetchAllUsers(UserSearchCriteria userSearchCriteria);

	public Optional<User> fetchUserById(Long userId);

	public User updateUserDetails(User user);

	public String deleteUser(Long userId);
}
