package com.app.model;

import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "flightReservation")
public class FlightReservation {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flightSchedule_id", referencedColumnName = "id")
	private FlightSchedule flightSchedule;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "flightReservation_passenger_mapping", joinColumns = {
			@JoinColumn(name = "flightReservation_reservationID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "passenger_id", referencedColumnName = "id") })
	@MapKey(name = "seatNo")
	private Map<Integer, Passenger> seatPassengerMap;

	@Column(name = "transactionDate")
	private Timestamp transactionDate;

	@Column(name = "status")
	private String status;
}
