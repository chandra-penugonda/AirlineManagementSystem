package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.UserSearchCriteria;
import com.app.criteria.specification.UserSearchSpecification;
import com.app.exception.DuplicateDataException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String addUser(User user) {

		Optional<User> userById = userRepository.findById(user.getId());

		if (!userById.isPresent()) {
			userRepository.save(user);
			return "User added successfully";
		} else {
			throw new DuplicateDataException("User already exists with Id: " + user.getId());
		}
	}

	@Override
	public Page<User> fetchAllUsers(UserSearchCriteria userSearchCriteria) {
		return userRepository.findAll(UserSearchSpecification.findByCriteria(userSearchCriteria),
				userSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<User> fetchUserById(Long userId) {

		return userRepository.findById(userId);
	}

	@Override
	public User updateUserDetails(User user) {

		Optional<User> userById = userRepository.findById(user.getId());

		if (userById.isPresent()) {
			userRepository.save(user);
		} else {
			throw new ResourceNotFoundException("User with Id: " + user.getId() + " not exists");
		}
		return user;
	}

	@Override
	public String deleteUser(Long userId) {

		Optional<User> userById = userRepository.findById(userId);

		if (userById.isPresent()) {
			userRepository.deleteById(userId);
			return "User deleted successfully";
		} else {
			throw new ResourceNotFoundException("User with Id: " + userId + " not exists");
		}
	}
}
