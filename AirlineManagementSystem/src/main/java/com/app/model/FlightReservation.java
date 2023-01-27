package com.app.model;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class FlightReservation {

	@Id
	private Long reservationID;
	@OneToOne(fetch = FetchType.LAZY)
	private FlightSchedule flightSchedule;
	private Map<Integer, Passenger> seatMap;
	private LocalDateTime transactionDate;
	private String status;
}
