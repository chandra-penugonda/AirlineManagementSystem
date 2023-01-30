package com.app.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "flightSchedule")
public class FlightSchedule {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id", referencedColumnName = "id")
	private Flight flight;

	@Column(name = "departureTime")
	private Timestamp departureTime;

	@Column(name = "arrivalTime")
	private Timestamp arrivalTime;

	@Column(name = "status")
	private String flightStatus;
}
