package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.app.model.enums.UserType;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private Long userId;
	private UserType userType;
	private String userName;
	private String password;
	private String mobileNo;
	private String emailId;
}
