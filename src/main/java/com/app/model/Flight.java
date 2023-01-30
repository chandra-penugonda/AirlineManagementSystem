package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String flightName;

	@OneToOne(fetch = FetchType.LAZY)
	private Airport source;

	@OneToOne(fetch = FetchType.LAZY)
	private Airport destination;

	@Column(name = "seatCapacity")
	private int seatingCapacity;

	@Column(name = "pricePerSeat")
	private double pricePerSeat;
}