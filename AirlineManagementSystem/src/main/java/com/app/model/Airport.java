package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Airport {

	@Id
	private Long airportCode;
	private String airportLocation;
	private String airportName;
}
