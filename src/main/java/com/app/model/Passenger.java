package com.app.model;

import javax.persistence.Entity;

import com.app.model.enums.IdentityType;

import lombok.Data;

@Entity
@Data
public class Passenger {

	private String name;
	private int age;
	private IdentityType identityType;
	private String identityCode;
	private String eMail;
	private int mobileNo;

}
