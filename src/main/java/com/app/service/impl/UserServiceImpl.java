package com.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.criteria.UserSearchCriteria;
import com.app.criteria.specification.UserSearchSpecification;
import com.app.dao.UserDao;
import com.app.exception.DuplicateDataException;
import com.app.exception.ResourceNotFoundException;
import com.app.model.User;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public String addUser(User user) {

		Optional<User> userById = userDao.findById(user.getUserId());

		if (!userById.isPresent()) {
			userDao.save(user);
			return "User added successfully";
		} else {
			throw new DuplicateDataException("User already exists with Id: " + user.getUserId());
		}
	}

	@Override
	public Page<User> fetchAllUsers(UserSearchCriteria userSearchCriteria) {
		return userDao.findAll(UserSearchSpecification.findByCriteria(userSearchCriteria),
				userSearchCriteria.toPageRequest());
	}

	@Override
	public Optional<User> fetchUserById(Long userId) {

		return userDao.findById(userId);
	}

	@Override
	public User updateUserDetails(User user) {

		Optional<User> userById = userDao.findById(user.getUserId());

		if (userById.isPresent()) {
			userDao.save(user);
		} else {
			throw new ResourceNotFoundException("User with Id: " + user.getUserId() + " not exists");
		}
		return user;
	}

	@Override
	public String deleteUser(Long userId) {

		Optional<User> userById = userDao.findById(userId);

		if (userById.isPresent()) {
			userDao.deleteById(userId);
			return "User deleted successfully";
		} else {
			throw new ResourceNotFoundException("User with Id: " + userId + " not exists");
		}
	}
}
