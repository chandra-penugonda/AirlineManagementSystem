package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/getAllUserInfo")
	public List<User> fetchAllUsers() {
		return userService.fetchAllUsers();
	}

	@GetMapping("/getUserInfo/{id}")
	public User fetchUserById(@PathVariable("id") Long userId) {
		Optional<User> userById = userService.fetchUserById(userId);
		return userById.orElseThrow(EntityNotFoundException::new);
	}

	@PutMapping("/updateUserInfo")
	public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
		User updatedUser = userService.updateUserDetails(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUserInfo(@PathVariable("id") Long userId) {
		return userService.deleteUser(userId);
	}

}
