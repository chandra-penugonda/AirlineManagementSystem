package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.enums.IdentityType;

import lombok.Data;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "identityType")
	private String identityType;

	@Column(name = "identityCode")
	private String identityCode;

	@Column(name = "email")
	private String eMail;

	@Column(name = "mobile")
	private int mobileNo;

	@Column(name = "seatNo")
	private Integer seatNo;
}
