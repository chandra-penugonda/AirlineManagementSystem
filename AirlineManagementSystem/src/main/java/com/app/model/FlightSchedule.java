package com.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class FlightSchedule {

	@Id
	private Long flightScheduleId;
	@OneToOne(fetch = FetchType.LAZY)
	private Flight flight;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private String flightStatus;
}
