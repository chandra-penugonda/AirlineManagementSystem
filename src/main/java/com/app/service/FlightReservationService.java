package com.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.criteria.FlightReservationSearchCriteria;
import com.app.model.FlightReservation;

public interface FlightReservationService {

	public String createFlightReservation(FlightReservation flightReservation);

	public Page<FlightReservation> fetchAllFlightReservations(FlightReservationSearchCriteria flightReservationSearchCriteria);

	public Optional<FlightReservation> fetchFlightReservationById(Long flightReservationId);

	public FlightReservation updateFlightReservationDetails(FlightReservation flightReservation);

	public String deleteFlightReservation(Long flightReservationId);
}
