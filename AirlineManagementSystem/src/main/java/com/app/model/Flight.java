package com.app.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Flight {

	@Id
	private Long flightID;
	private String flightName;
	@OneToOne(fetch = FetchType.LAZY)
	private Airport source;
	@OneToOne(fetch = FetchType.LAZY)
	private Airport destination;
	private int seatingCapacity;
	private double pricePerSeat;
}