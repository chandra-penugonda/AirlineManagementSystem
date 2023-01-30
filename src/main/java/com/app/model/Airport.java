package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "airport")
public class Airport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "code")
	private String airportCode;

	@Column(name = "location")
	private String airportLocation;

	@Column(name = "name")
	private String airportName;
}
