package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "userType")
	private String userType;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile")
	private String mobileNo;

	@Column(name = "email")
	private String emailId;
}
